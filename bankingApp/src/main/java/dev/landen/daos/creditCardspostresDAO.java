package dev.landen.daos;

import dev.landen.entities.app_user;
import dev.landen.entities.bank_accounts;
import dev.landen.entities.creditCards;
import dev.landen.utils.ConnectionUtil;

import java.sql.*;


public class creditCardspostresDAO implements creditCardsDAO {

    @Override
    public creditCards createCreditaccount(creditCards creditCards) {

        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "insert into banking_app.credit_card_accounts (user_credit_card_numbers) values (?);";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);//
            ps.setInt(1, creditCards.getUser_credit_card_numbers());
            ps.execute();

            // getting the generated primary key value
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int generatedId = rs.getInt("credit_card_id");

            creditCards.setUser_credit_card_numbers(generatedId);// the user id changing for 0 to a non zero values means that it is saved
            return creditCards;

        } catch (
                SQLException exception) {
            exception.printStackTrace();
        }


        return null;
    }

    @Override
    public app_user getCreditcardIdbyUsernameandPassword(String username, String pswd) {

        {

            try (Connection conn = ConnectionUtil.getConnection()) {
                String sql = "select * from banking_app.credit_card_accounts join banking_app.app_users on username = ? and pswd = ? where user_account_number = id;";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, pswd);

                ResultSet rs = ps.executeQuery(); // JDBC actually interacts with the DB

                rs.next();

                app_user appUser = new app_user();
                appUser.setCredit_card_id(rs.getInt("credit_card_id"));
                return appUser;

            } catch (SQLException exception) {
                exception.printStackTrace();
            }

            return null;
        }



    }

    @Override
    public creditCards updateCreditaccount(creditCards creditCards) {

        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "Update banking_app.credit_card_accounts set credit_card_id  = default where credit_card_id  = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, creditCards.getCredit_card_id());
            ps.execute();

            return creditCards;

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public creditCards deleteCreditaccount(int userAccountid) {

        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "delete from banking_app.credit_card_accounts where credit_card_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userAccountid);
            ps.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();

        }

        return null;
    }
}