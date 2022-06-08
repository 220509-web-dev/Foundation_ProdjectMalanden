package dev.landen.daos;

import dev.landen.entities.app_user;
import dev.landen.entities.bank_accounts;
import dev.landen.entities.mortgageAccounts;
import dev.landen.utils.ConnectionUtil;

import java.sql.*;

public class mortgagePostgresDao implements mortgageDAO{
    @Override
    public mortgageAccounts createMortgageaccount(mortgageAccounts mortgageAccounts) {

        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "insert into banking_app.mortgage_accounts (user_mortgage_account_number) values (?);";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);//
            ps.setInt(1,  mortgageAccounts.getUser_mortgage_account_number());
            ps.execute();

            // getting the generated primary key value
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int generatedId = rs.getInt("mortgage_id");

            mortgageAccounts.setMortgage_id(generatedId);// the user id changing for 0 to a non zero values means that it is saved
            return mortgageAccounts;

        } catch (
                SQLException exception) {
            exception.printStackTrace();
        }

        return null;
    }

    @Override
    public app_user getmortgagebyUsernameandPassword(String username, String pswd) {

        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "select * from banking_app.mortgage_accounts join banking_app.app_users on username = ? and pswd = ? where user_account_number = id;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,pswd);

            ResultSet rs = ps.executeQuery(); // JDBC actually interacts with the DB

            rs.next();


            mortgageAccounts mortgageid = new mortgageAccounts();
            mortgageid.getMortgage_id();

            app_user appUser = new app_user();
            appUser.setBank_id(rs.getInt("mortgage_id"));
            return appUser;


        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return null;
    }

    @Override
    public mortgageAccounts updatemortgageaccount(mortgageAccounts mortgageAccounts){

        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "Update banking_app.mortgage_accounts set mortgage_id  = default where mortgage_id  = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, mortgageAccounts.getMortgage_id());
            ps.execute();

            return mortgageAccounts;

        } catch (SQLException exception) {
            exception.printStackTrace();
        }


        return null;
    }

    @Override
    public  mortgageAccounts deletemortgageaccount(int userAccountid) {

        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "delete from banking_app.mortgage_accounts where mortgage_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,userAccountid);
            ps.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();

        }

        return null;
    }
}
