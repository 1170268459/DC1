package dao.impl;


import comm.JDBCUitl;
import dao.userdao;
import domin.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userdaoImpl implements userdao {
    @Override
    public boolean login(User user) {
        try {
            Connection conn = JDBCUitl.getConnection();
            PreparedStatement statement = conn.prepareStatement("select * from  user where  uname=? and pwd=?");
            statement.setString(1, user.getName());
            statement.setString(2, user.getName());
            ResultSet resultSet = statement.executeQuery();
            // JDBCUitl.close(conn,statement,resultSet);
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }



    @Override
    public boolean regesit(User user) {

        /*   PreparedStatement statement= null;*/
        try {
            Connection conn = JDBCUitl.getConnection();
            PreparedStatement statement = conn.prepareStatement("insert  into user values (?,?)");
            statement.setString(1, user.getName());

            statement.setString(2, user.getPassword());
            int resultSet = statement.executeUpdate();

            if (resultSet > 0) {
                return true;
            }
            // JDBCUitl.close(conn,statement,null);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deluser(String name) {
        Connection conn = null;
        try {
            conn = JDBCUitl.getConnection();
            PreparedStatement statement = conn.prepareStatement("delete from user where  uname =?");
            statement.setString(1,name);
            int del=statement.executeUpdate();
            if (del> 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updatau(User user) {
        try {
            Connection conn= JDBCUitl.getConnection();
            PreparedStatement statement=conn.prepareStatement("update user set pwd=? where uname=?");
            statement.setString(1,user.getPassword());
            statement.setString(2,user.getName());

            int i = statement.executeUpdate();
            if(i>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
