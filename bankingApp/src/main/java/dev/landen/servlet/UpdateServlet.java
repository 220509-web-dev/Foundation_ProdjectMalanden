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
import java.util.List;

public class UpdateServlet extends HttpServlet {

  ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        app_userDAO DAO = new appUserDaoPostgres();
        app_user username = mapper.readValue(req.getInputStream(), app_user.class);


        app_userDAO app_userDAO = new appUserDaoPostgres();
        List<app_user> allUsers = app_userDAO.getAllusers();
        String allUserString = allUsers.toString();

        if(allUserString.contains(username.getUsername())) {
            System.out.println("Username already taken");
        }else{
        app_user user = DAO.updateUser(username.getUsername(), username.getId());
        System.out.println("user updated");}


        resp.setStatus(204);

    }
}
