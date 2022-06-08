package dev.landen.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.landen.daos.appUserDaoPostgres;
import dev.landen.daos.app_userDAO;
import dev.landen.entities.app_user;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.landen.daos.appUserDaoPostgres;
import dev.landen.daos.app_userDAO;
import dev.landen.entities.app_user;
import dev.landen.utils.exceptions.BadCredentialsExceptions;

import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;


public class UserLoginServlet extends HttpServlet {

    ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws BadCredentialsExceptions, ServletException, IOException {

        //get user with username and password
        try {

            app_user newUser = mapper.readValue(req.getInputStream(), app_user.class);
            app_userDAO app_userDAO = new appUserDaoPostgres();
            app_user user = app_userDAO.getuserByuserNameandPassword(newUser.getUsername(), newUser.getPswd());

            if (user.getUsername() == newUser.getUsername() ){
                System.out.println("user is already taken");

            }


            System.out.println(user);
            System.out.println("Login sucessfull!");

        } catch (Exception e) {
            System.out.println("Error connecting to the database");
            e.printStackTrace();
        }

        resp.setStatus(204);
    }
}
