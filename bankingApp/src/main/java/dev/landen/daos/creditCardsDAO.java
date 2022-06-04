package dev.landen.daos;

import dev.landen.entities.app_user;
import dev.landen.entities.bank_accounts;
import dev.landen.entities.creditCards;

public interface creditCardsDAO {

    //Create
    creditCards createCreditaccount(creditCards creditCards);



    //Read


    app_user getCreditcardIdbyUsernameandPassword(String username, String pswd);


    //update
    creditCards updateCreditaccount(creditCards creditCards);



    //Delete
    creditCards deleteCreditaccount(int userAccountid);

}


