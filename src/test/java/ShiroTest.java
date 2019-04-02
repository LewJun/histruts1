import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShiroTest {
    @Test
    public void testShiro() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("zhang3", "12345"));
        userList.add(new User("li4", "abcde"));
        userList.add(new User("wang5", "123456"));
        userList.add(new User("zs", "123"));
        for (User user : userList) {
            Subject subject = getSubject();
            // 如果登录成功
            if (login(subject, user)) {
                Serializable id = subject.getSession().getId();
                System.out.println(id);

                System.out.println(subject.hasRole("admin"));
                System.out.println(subject.isPermitted("addProduct"));

                System.out.println(subject.hasRole("productManager"));
                System.out.println(subject.isPermitted("delProduct"));

                System.out.println(subject.hasRole("orderManager"));
                System.out.println(subject.isPermitted("addOrder"));
                subject.logout();
            }
        }
    }

    /**
     * Subject 在 Shiro 这个安全框架下， Subject 就是当前用户
     *
     * @return
     */
    private Subject getSubject() {
        //加载配置文件，并获取工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        //获取安全管理者实例
        SecurityManager sm = factory.getInstance();
        //将安全管理者放入全局对象
        SecurityUtils.setSecurityManager(sm);
        //全局对象通过安全管理者生成Subject对象
        return SecurityUtils.getSubject();
    }

    private boolean login(Subject subject, User user) {
        // 封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(
                user.username, user.password
        );
        try {
            // 将用户的数据token最终传递到Realm进行比较
            subject.login(token);
            return subject.isAuthenticated();
        } catch (Exception e) {
            e.printStackTrace();
            // 验证错误
            return false;
        }
    }
}
