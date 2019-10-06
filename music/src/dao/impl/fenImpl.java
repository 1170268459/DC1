package dao.impl;

import comm.JDBCUitl;
import dao.fen;
import domin.Fen;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class fenImpl implements fen {
    @Override
    public boolean add(Fen fe) {
        try {
            Connection conn= JDBCUitl.getConnection();
            PreparedStatement st=conn.prepareStatement("insert  into fen values (?,?)");
            st.setInt(1,fe.getId());
            int i = st.executeUpdate();
            if(i>0){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Fen fe) {
        try {
            Connection conn= JDBCUitl.getConnection();
            PreparedStatement st=conn.prepareStatement("delete from  fen where  id=?");
            st.setInt(1,fe.getId());
            int i = st.executeUpdate();
            if(i>0){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean select(Fen fe) {
        try {
            Connection conn= JDBCUitl.getConnection();
            PreparedStatement st=conn.prepareStatement("select * from fen where  id=? or fen=?");
            st.setInt(1,fe.getId());
            st.setString(2,fe.getFen());

            ResultSet resultSet = st.executeQuery();
            if(resultSet.next()){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Fen fe) {
        try {
            Connection conn= JDBCUitl.getConnection();
            PreparedStatement statement=conn.prepareStatement("update fen set fen=? where id=?");

            statement.setInt(1,fe.getId());
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
