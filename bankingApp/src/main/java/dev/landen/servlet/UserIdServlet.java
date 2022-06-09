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

public class UserIdServlet extends HttpServlet {

    ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //get all users
        app_userDAO DAO = new appUserDaoPostgres();
        app_user newUser = mapper.readValue(req.getInputStream(), app_user.class);
        app_user user = DAO.getuserById(newUser.getId());
        System.out.println("The user that you are looking for is " + user.getFirst_name() + " " + user.getLast_name());


        resp.setStatus(204);

    }

}
