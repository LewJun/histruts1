import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * DbUtils的使用
 */
public class DbUtilsTest {

    private Connection conn;

    @Before
    public void before() throws SQLException {
        conn = getConnection();
    }

    @After
    public void after() throws SQLException {
        DbUtils.close(conn);
    }

    @Test
    public void testInsert() throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "INSERT INTO user(username, password) VALUES (?,?)";
        int r = queryRunner.update(conn, sql, "zs", "123");
        System.out.println(r);
    }

    @Test
    public void testEdit() throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "update user set password=? where username=?";
        int r = queryRunner.update(conn, sql, "zs", "1234");
        System.out.println(r);
    }

    @Test
    public void testQueryList() throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from user where id>?";
        List<User> userList = queryRunner.query(conn, sql, new BeanListHandler<>(User.class), 1);
        System.out.println(userList);
    }

    @Test
    public void testQueryById() throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from user where id = ?";
//        bean 的 属性需要有setter和getter
        User user = queryRunner.query(conn, sql, new BeanHandler<>(User.class), 1);
        System.out.println(user);
    }

    @Test
    public void testDel() throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "delete from user where username = ?";
        int r = queryRunner.update(conn, sql, "zs");
        System.out.println(r);
    }

    private Connection getConnection() throws SQLException {
        String driverClassName = "org.sqlite.JDBC";
        String username = "SA";
        String password = "";
        String url = "jdbc:sqlite:histruts1.db";

        DbUtils.loadDriver(driverClassName);
        return DriverManager.getConnection(url, username, password);
    }
}
