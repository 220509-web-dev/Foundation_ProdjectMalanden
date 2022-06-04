package dev.landen.app;
import java.util.Scanner;
import dev.landen.daos.appUserDaoPostgres;
import dev.landen.daos.app_userDAO;
import dev.landen.daos.baccDaoPostgres;
import dev.landen.daos.bankAccountsDAO;
import dev.landen.entities.app_user;
import dev.landen.entities.bank_accounts;

import java.util.ArrayList;
import java.util.List;
public class getAlltest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        bankAccountsDAO test = new baccDaoPostgres();

        app_userDAO apptest = new appUserDaoPostgres();


        app_user test1 = new app_user();

         int james = 22;

       bank_accounts ken = test.deleteBankaccount(james);





        List<app_user> getAllusers = new ArrayList<>();

       System.out.println(ken);
    }
}