package dev.landen.daos;

import dev.landen.entities.app_user;
import dev.landen.entities.bank_accounts;
import dev.landen.utils.ConnectionUtil;

import java.sql.*;

public class baccDaoPostgres implements bankAccountsDAO {


    @Override
    public bank_accounts createBankaccount(bank_accounts bank_accounts) {

        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "insert into banking_app.bank_accounts (user_account_number) values (?);";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);//
            ps.setInt(1,  bank_accounts.getApp_user_account_number());
            ps.execute();

            // getting the generated primary key value
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int generatedId = rs.getInt("bank_id");

            bank_accounts.setBank_id(generatedId);// the user id changing for 0 to a non zero values means that it is saved
            return bank_accounts;

        } catch (
                SQLException exception) {
            exception.printStackTrace();
        }
        return null;

    }


    @Override
    public app_user getbankIdbyUsernameandPassword(String username, String pswd) {

        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "select * from banking_app.bank_accounts join banking_app.app_users on username = ? and pswd = ? where user_account_number = id;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,pswd);

            ResultSet rs = ps.executeQuery(); // JDBC actually interacts with the DB

            rs.next();

             bank_accounts bankid = new bank_accounts();
             bankid.getBank_id();

            app_user appUser = new app_user();
            appUser.setBank_id(rs.getInt("bank_id"));
            return appUser;


        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return null;



    }

    @Override
    public bank_accounts updatebankaccount(bank_accounts bank_accounts) {

        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "Update banking_app.bank_accounts set bank_id  = default where bank_id  = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, bank_accounts.getBank_id());
            ps.execute();

            return bank_accounts;

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;

    }

    @Override
    public bank_accounts deleteBankaccount(int userAccountid) {

        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "delete from banking_app.bank_accounts where bank_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,userAccountid);
            ps.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();

        }




        return null;
    }
}