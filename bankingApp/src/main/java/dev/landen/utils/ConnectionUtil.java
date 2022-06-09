package dev.landen.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

    private Properties props = new Properties();

    public static Connection getConnection(){

        try {

           // String dbInfo = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=revature";
            String dbInfo = System.getenv("DB_CONNECTION");
            Connection connection = DriverManager.getConnection(dbInfo);
            return connection;


        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}


