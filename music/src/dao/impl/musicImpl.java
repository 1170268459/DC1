package dao.impl;

import comm.JDBCUitl;
import dao.musicdao;
import domin.Music;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class musicImpl implements musicdao {
    @Override
    public boolean add(Music music) {
        try {
            Connection conn= JDBCUitl.getConnection();
            PreparedStatement statement=conn.prepareStatement("insert into min values (?,?,?)");
            statement.setInt(1,music.getId());
            statement.setString(2,music.getFen());
            statement.setString(3,music.getMin());
            int i = statement.executeUpdate();
            if(i>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean delete(int id) {
        try {
            Connection conn= JDBCUitl.getConnection();
            PreparedStatement statement=conn.prepareStatement("delete from min where   id =?");
           statement.setInt(1,id);
            int i = statement.executeUpdate();
            if(i>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean select(Music music) {
        try {
            Connection conn= JDBCUitl.getConnection();
            PreparedStatement statement=conn.prepareStatement("select * from min where id=? or  fen=? or min=?");
            statement.setInt(1,music.getId());
            statement.setString(2,music.getFen());
            statement.setString(3,music.getMin());
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Music music) {
        try {
            Connection conn= JDBCUitl.getConnection();
            PreparedStatement statement=conn.prepareStatement("update min set fen=?,min=? where id=?");
            statement.setString(2,music.getFen());
            statement.setString(3,music.getMin());
            statement.setInt(1,music.getId());
            int i = statement.executeUpdate();
            if(i>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int selectAll() {
        int count=0;
        try {
            Connection conn=JDBCUitl.getConnection();
            PreparedStatement stat=conn.prepareStatement("select  * from min");
            ResultSet resultSet = stat.executeQuery();
            while (resultSet.next()){
                count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public List<Music> show() {
        List<Music> list=new ArrayList<>();
        try {

            Connection conn= JDBCUitl.getConnection();
            PreparedStatement st=conn.prepareStatement("select * from min");
            ResultSet re = st.executeQuery();
            while (re.next()){
                list.add(new Music(re.getInt(1),re.getString(2),re.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
