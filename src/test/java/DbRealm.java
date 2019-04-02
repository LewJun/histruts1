import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 当应用程序向 Shiro 提供了 账号和密码之后， Shiro 就会问 Realm 这个账号密码是否对， 如果对的话，其所对应的用户拥有哪些角色，哪些权限。
 * 所以Realm 是什么？ 其实就是个中介。 Realm 得到了 Shiro 给的用户和密码后，有可能去找 ini 文件，就像shiro.ini，也可以去找数据库
 * <p>
 * 这个类，用户提供，但是不由用户自己调用，而是由 Shiro 去调用（需要在shiro.ini中配置）。
 * 就像Servlet的doPost方法，是被Tomcat调用一样。
 */
public class DbRealm extends AuthorizingRealm {
    private static final Logger LOGGER = LoggerFactory.getLogger(DbRealm.class);

    /**
     * 得到用户的角色权限信息
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        LOGGER.info("1 doGetAuthorizationInfo");
        // 能进入表示账号已经通过验证了
        String username = (String) principalCollection.getPrimaryPrincipal();
        LOGGER.info("username:{}", username);

        UserDao userDao = new UserDao();
        List<Role> roles = userDao.queryRolesByUsername(username);
        Set<String> roleSet = new HashSet<>();
        for (Role role : roles) {
            roleSet.add(role.name);
        }

        List<Permission> permissions = userDao.queryPermissionsByUsernae(username);
        Set<String> permissionSet = new HashSet<>();
        for (Permission p : permissions) {
            permissionSet.add(p.name);
        }

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//        把角色放进去
        if (!roleSet.isEmpty()) simpleAuthorizationInfo.setRoles(roleSet);
//        把权限放进去
        if (!permissionSet.isEmpty()) simpleAuthorizationInfo.setStringPermissions(permissionSet);
        return simpleAuthorizationInfo;
    }

    /**
     * 得到验证通过的用户信息
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        LOGGER.info("2 doGetAuthenticationInfo");
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getPrincipal().toString();
        String password = new String(usernamePasswordToken.getPassword());

        LOGGER.info("username:{}, password:{}", username, password);
        UserDao userDao = new UserDao();
//        在数据库查询是否有该用户
        User user = userDao.queryByUsername(username);

//        如果没有查询到用户名对应的用户或者比较密码错误，抛出异常登录失败
//        把用户通过 UsernamePasswordToken 传进来的密码，以及数据库里取出来的 salt 进行加密，加密之后再与数据库里的密文进行比较，判断用户是否能够通过验证。
        if (user == null || !user.password.equals(new SimpleHash("md5", password, user.salt, 2).toString())) {
            throw new AuthenticationException("login error");
        }

        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
