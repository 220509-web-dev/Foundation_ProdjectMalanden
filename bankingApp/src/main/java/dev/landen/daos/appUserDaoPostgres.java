package dev.landen.daos;

import dev.landen.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import dev.landen.entities.app_user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class appUserDaoPostgres implements app_userDAO {



    @Override
    public app_user createapp_user(app_user app_user) {


        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "insert into banking_app.app_users (first_name, last_name, email, username, pswd) values (?,?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);//
            ps.setString(1, app_user.getFirst_name());
            ps.setString(2, app_user.getLast_name());
            ps.setString(3, app_user.getEmail());
            ps.setString(4, app_user.getUsername());
            ps.setString(5, app_user.getPswd());


            ps.execute();

            // getting the generated primary key value
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int generatedId = rs.getInt("id");

            app_user.setId(generatedId);// the user id changing for 0 to a non zero values means that it is saved
            return app_user;

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;

    }



        @Override
    public app_user getuserByuserNameandPassword(String username, String pswd) {

        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "select * from banking_app.app_users where username = ? and pswd = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,pswd);

            ResultSet rs = ps.executeQuery(); // JDBC actually interacts with the DB

            rs.next();

            app_user appUser = new app_user();
            appUser.setId(rs.getInt("id"));
            appUser.setFirst_name(rs.getString("first_name"));
            appUser.setLast_name(rs.getString("last_name"));
            appUser.setEmail(rs.getString("email"));
            appUser.setUsername(rs.getString("username"));
            appUser.setPswd(rs.getString("pswd"));
            return appUser;

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return null;
    }

    @Override
    public  app_user getuserById(int id) {

        // try with resources. Automatically closes the connection once the try block finishes

        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "select * from banking_app.app_users where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery(); // JDBC actually interacts with the DB

            //Get First Record
            rs.next();

            // Create a user and set the values of that book to the information in the result set
            app_user appUser = new app_user();
            appUser.setId(id);
            appUser.setFirst_name(rs.getString("first_name"));
            appUser.setLast_name(rs.getString("last_name"));
            appUser.setEmail(rs.getString("email"));
            appUser.setUsername(rs.getString("username"));
            appUser.setPswd(rs.getString("pswd"));

            return appUser;

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return null;
    }

    @Override
    public List<app_user> getAllusers () {

        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "select * from banking_app.app_users";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<app_user> app_users = new ArrayList<>();

            while (rs.next()){
                app_user app_user = new app_user();

                app_user.setId(rs.getInt("id"));
                app_user.setFirst_name(rs.getString("first_name"));
                app_user.setLast_name(rs.getString("last_name"));
                app_user.setEmail(rs.getString("email"));
                app_user.setUsername(rs.getString("username"));
                app_user.setPswd(rs.getString("pswd"));

            }
            return app_users;

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;


    }

    @Override
    public app_user updateuser(app_user app_user) {

        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "update banking_app.app_users set (first_name, last_name, email, username, pswd) values (?,?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, app_user.getFirst_name());
            ps.setString(2, app_user.getLast_name());
            ps.setString(3, app_user.getEmail());
            ps.setString(4, app_user.getUsername());
            ps.setString(5, app_user.getPswd());

            ps.execute();

            return app_user;

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }




    @Override
    public void deleteapp_userById(int id) {

        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "delete from banking_app.app_users where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }


}
