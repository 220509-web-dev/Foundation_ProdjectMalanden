package dev.landen.utils;



import com.fasterxml.jackson.databind.ObjectMapper;
import dev.landen.daos.appUserDaoPostgres;
import dev.landen.daos.app_userDAO;
import dev.landen.servlet.UserServlet;

import javax.servlet.*;
import java.time.LocalDateTime;
import java.util.EnumSet;

public class ContextLoaderListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        System.out.println("[LOG] - The servlet context was initialized at " + LocalDateTime.now());

        ObjectMapper mapper = new ObjectMapper();

        app_userDAO userDao = new appUserDaoPostgres();

        UserServlet userServlet = new UserServlet();


        ServletContext context = sce.getServletContext();


        ServletRegistration.Dynamic userServlet1 = context.addServlet("UserServlet", userServlet);

        userServlet1.setLoadOnStartup(3);
        userServlet1.setInitParameter("user-servlet-key", "user-servlet-value");
        userServlet1.setInitParameter("another-param", "another-value");
        userServlet1.addMapping("/user/*");

   }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("[LOG] - The servlet context was destroyed at " + LocalDateTime.now());
    }

}
