package dev.landen.app;

import dev.landen.daos.appUserDaoPostgres;
import dev.landen.daos.app_userDAO;
import dev.landen.entities.app_user;
import dev.landen.utils.ConnectionUtil;
import java.util.Scanner;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class App {


    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);


        System.out.println("Hello user please choose a response");
        System.out.println("1)Login\n2)Register\n3)Exit\n");

        int choice = scanner.nextInt();

        switch (choice) {

            case 1:

                while (true) {

                    System.out.println("please enter your username. ");
                    String userIn1 = scanner.next();
                    System.out.println("please enter you password. ");
                    String userIn2 = scanner.next();
                    app_userDAO app_userDAO = new appUserDaoPostgres();
                    app_user user = app_userDAO.getuserByuserNameandPassword(userIn1, userIn2);
                    System.out.println(user);
                   break;

                }
                break;

            case 2:
                System.out.println("Please provide your registration info ");
                while (true) {

                    app_userDAO app_userDAO = new appUserDaoPostgres();
                    System.out.println("Enter your first name");
                    String first_name = scanner.next();
                    System.out.println("Enter your last name");
                    String last_name = scanner.next();
                    System.out.println("Enter your email address");
                    String email = scanner.next();
                    System.out.println("Enter your username");
                    String username = scanner.next();
                    System.out.println("Enter your password");
                    String password = scanner.next();

                    app_user newUser = new app_user(0, first_name, last_name, email, username, password);
                    app_user user = app_userDAO.createapp_user(newUser);

                    System.out.println("congratulations you are now registered " + user);

                    break;
                }
                 break;

            case 3:
                System.out.println("You are now exiting ");
                break;


        }


    }
}



