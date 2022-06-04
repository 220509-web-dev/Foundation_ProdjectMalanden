package dev.landen.daos;

import dev.landen.entities.app_user;
import dev.landen.entities.bank_accounts;

public interface mortgageDAO {


    //Create
    bank_accounts createMortgageaccount(bank_accounts bank_accounts);


    //Read

    app_user getmortgagebyUsernameandPassword(String username, String pswd);


    //update
    bank_accounts updatemortgageaccount(bank_accounts bank_accounts);



    //Delete
    bank_accounts deletemortgageaccount(int userAccountid);



}
