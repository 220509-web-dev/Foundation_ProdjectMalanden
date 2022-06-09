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

import dev.landen.utils.exceptions.BadCredentialsExceptions;

import java.util.List;


public class AuthServlet extends HttpServlet {

    ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws BadCredentialsExceptions, ServletException, IOException {

        //get user with username and password
        try {
            app_user newUser = mapper.readValue(req.getInputStream(), app_user.class);
            app_userDAO app_userDAO = new appUserDaoPostgres();
            List<app_user> allUsers = app_userDAO.getAllusers();
            String allUserString = allUsers.toString();

            if(allUserString.contains(newUser.getUsername()) && allUserString.contains(newUser.getPswd())){
                app_user user = app_userDAO.getuserByuserNameandPassword(newUser.getUsername(), newUser.getPswd());
                System.out.println("Thank you " + user.getFirst_name() + " for logging in");
            }else{
                System.out.println("Username or password incorrect please try again.");
            }



        } catch (BadCredentialsExceptions e) {
            System.out.println("Error connecting to the database");
            e.printStackTrace();
        }

        resp.setStatus(204);
    }
}
