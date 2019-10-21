import com.mysql.jdbc.Driver;
import org.junit.Test;

import java.sql.*;

public class TestUser {
    @Test
    public void test1() throws SQLException, ClassNotFoundException {
        //1、加载数据库驱动
       // DriverManager.registerDriver(new Driver());
        Class.forName("com.mysql.jdbc.Driver");
        //2、连接数据库（需要用户名和密码以及数据库服务器连接地址）
        String url = "jdbc:mysql://localhost:3306/employee";//最后是需要连接的数据库名字
        String userName = "root";
        String passWord = "88888888";//数据库密码
        //通过连接数据库产生连接数据库的连接对象
        Connection conn = DriverManager.getConnection(url, userName, passWord);
        //3、创建执行sql语句的对象
        Statement state = conn.createStatement();
        //4、执行sql语句，返回结果集
        String sql = "select * from emp";//sql语句
        ResultSet rs = state.executeQuery(sql);
        //5、处理结果集
        while (rs.next()) {
            String s1 = rs.getString(1);
            String s2 = rs.getString(2);
            String s3 = rs.getString("job");
            String s4 = rs.getString("hiredate");
            System.out.println(s1 + "\t" + s2 + "\t" + s3 + "\t" + s4);
        }

            //6、释放资源
            rs.close();
            state.close();
            conn.close();
    }
        @Test
        public void test2 () throws SQLException {
            //1、加载数据库驱动
            DriverManager.registerDriver(new Driver());
            //2、连接数据库（需要用户名和密码以及数据库服务器连接地址）
            String url = "jdbc:mysql://localhost:3306/employee";//最后是需要连接的数据库名字
            String userName = "root";
            String passWord = "88888888";//数据库密码
            //通过连接数据库产生连接数据库的连接对象
            Connection conn = DriverManager.getConnection(url, userName, passWord);
            //3、创建执行sql语句的对象
            Statement state = conn.createStatement();
            //4、执行sql语句，返回结果集
            String sql = "delete from emp where ename ='胡忠淼'";//sql语句
            int rs = state.executeUpdate(sql);
            System.out.println("i="+rs);

            state.close();
            conn.close();
        }
}
