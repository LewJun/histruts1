import com.microandroid.utils.DbUtils2;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserDao {
    /**
     * 根据用户名查找用户信息
     *
     * @param username
     * @return
     */
    public User queryByUsername(String username) {
        Connection sqliteConn = null;
        try {
            sqliteConn = DbUtils2.getSqliteConn();

            QueryRunner queryRunner = new QueryRunner();
            User user = queryRunner.query(sqliteConn, "select * from user where username=?", new BeanHandler<>(User.class), username);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(sqliteConn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<Role> queryRolesByUsername(String username) {
        Connection sqliteConn = null;
        try {
            sqliteConn = DbUtils2.getSqliteConn();

            String sql = "select r.* from user u \n" +
                    "left join user_role ur on u.id = ur.id_user\n" +
                    "left join role r on r.id = ur.id_role\n" +
                    "where u.username=?";
            QueryRunner queryRunner = new QueryRunner();
            return queryRunner.query(sqliteConn, sql, new BeanListHandler<>(Role.class), username);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(sqliteConn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<Permission> queryPermissionsByUsernae(String username) {
        Connection sqliteConn = null;
        try {
            sqliteConn = DbUtils2.getSqliteConn();

            String sql = "select p.* from user u \n" +
                    "left join user_role ur on u.id = ur.id_user\n" +
                    "left join role r on r.id = ur.id_role\n" +
                    "left join role_permission rp on r.id = rp.id_role\n" +
                    "left join permission p on p.id = rp.id_permission\n" +
                    "where u.username=?";
            QueryRunner queryRunner = new QueryRunner();
            return queryRunner.query(sqliteConn, sql, new BeanListHandler<>(Permission.class), username);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(sqliteConn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
