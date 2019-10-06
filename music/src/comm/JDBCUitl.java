package comm;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUitl {
    private static String username = null;
    private static String password = null;
    private static String url = null;
    private static String  driver=null;

    static {

        try {
            Properties properties = new Properties();
            InputStream in = JDBCUitl.class.getResourceAsStream("jdbc.properties");
            properties.load(in);
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            Class.forName(properties.getProperty("driver"));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
        public static Connection getConnection() throws SQLException {
        Connection conn=null;
        return  conn=DriverManager.getConnection(url,username,password);
    }
    public  static  void close(Connection con, PreparedStatement sta, ResultSet resultSet){
        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(sta!=null){
            try {
                sta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("全部已经关闭");

    }

}
