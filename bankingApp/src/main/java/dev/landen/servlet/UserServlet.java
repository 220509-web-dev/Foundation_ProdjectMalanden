package dev.landen.servlet;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.landen.daos.appUserDaoPostgres;
import dev.landen.daos.app_userDAO;
import dev.landen.entities.app_user;
import dev.landen.utils.exceptions.UserNameTakenException;

import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class UserServlet extends HttpServlet {

    // TODO what if other servlets also need an ObjectMapper? how to share this reference across classes
    ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //get all users
             app_userDAO DAO = new appUserDaoPostgres();
             List<app_user> someUser = DAO.getAllusers();
             System.out.println(someUser);


        resp.setStatus(204);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws UserNameTakenException, ServletException, IOException {

        System.out.println("[LOG] - UserServlet received a POST request at " + LocalDateTime.now());

        try {
            app_user newUser = mapper.readValue(req.getInputStream(), app_user.class);
            app_userDAO app_userDAO = new appUserDaoPostgres();
            List<app_user> allUsers = app_userDAO.getAllusers();
            String allUserString = allUsers.toString();

            if(allUserString.contains(newUser.getUsername())) {
                System.out.println("Username already taken");
            }else{ app_user user = app_userDAO.createapp_user(newUser);
                System.out.println(user);}

        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.setStatus(204);

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}