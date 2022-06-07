package dev.landen.daos;

import dev.landen.entities.app_user;
import dev.landen.entities.bank_accounts;
import dev.landen.entities.mortgageAccounts;

public interface mortgageDAO {


    //Create
    mortgageAccounts createMortgageaccount(mortgageAccounts mortgageAccounts);


    //Read

    app_user getmortgagebyUsernameandPassword(String username, String pswd);


    //update
    mortgageAccounts updatemortgageaccount(mortgageAccounts mortgageAccounts);



    //Delete
    mortgageAccounts deletemortgageaccount(int userAccountid);



}
