package com.microandroid.shiro;

import com.microandroid.modules.user.dto.User;
import com.microandroid.modules.user.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class DatabaseRealm extends AuthorizingRealm {
    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseRealm.class);

    @Autowired
    private IUserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        Set<String> roles = new HashSet<>();
        roles.add("productManager");
        simpleAuthorizationInfo.setRoles(roles);
        Set<String> perms = new HashSet<>();
        perms.add("delProduct");
        simpleAuthorizationInfo.setStringPermissions(perms);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken upt = (UsernamePasswordToken) token;
        String username = upt.getPrincipal().toString();
        User user = userService.selectByUsername(username);
        SimpleAuthenticationInfo a = new SimpleAuthenticationInfo(
                username
                , user.getPassword()
                , ByteSource.Util.bytes(user.getSalt())
                , getName());
        return a;

//        String password = new String(upt.getPassword());
//        如果用户不存在并且加密后的密码和数据库不能对应，抛出错误
//        if (user == null
//                || !new SimpleHash("md5", password, user.getSalt(), 1).toString()
//                .equals(user.getPassword())) {
//            throw new AuthenticationException();
//        }
//        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
