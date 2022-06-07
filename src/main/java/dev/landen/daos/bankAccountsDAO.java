package dev.landen.daos;

import dev.landen.entities.app_user;
import dev.landen.entities.bank_accounts;

public interface bankAccountsDAO {

    //Create
    bank_accounts createBankaccount(bank_accounts bank_accounts);



    //Read

     app_user getbankIdbyUsernameandPassword(String username, String pswd);


    //update
    bank_accounts updatebankaccount(bank_accounts bank_accounts);



    //Delete
    bank_accounts deleteBankaccount(int userAccountid);

}
