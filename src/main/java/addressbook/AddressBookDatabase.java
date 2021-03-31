package addressbook;

import java.sql.Connection;
import java.sql.*;


    public class AddressBookDatabase {
        private Connection getConnection() throws IllegalAccessException {
            String JDBCURL = "jdbc:mysql://localhost:3306/address_book_service?useSSL=false";
            String UserName = "root";
            String Password = "root";
            Connection connection = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver loaded");
            } catch (ClassNotFoundException e) {
                throw new IllegalAccessException(String.format("Driver not found in classpath%s", e));

            }
            try {
                System.out.println("Connecting to database" + JDBCURL);
                connection = DriverManager.getConnection(JDBCURL, UserName, Password);
                System.out.println("Connection succesfully" + connection);
            } catch (Exception e) {
                e.printStackTrace();

            }
            return connection;
        }
    }
