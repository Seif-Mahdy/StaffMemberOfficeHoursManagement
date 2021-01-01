package com;

    import java.io.PrintWriter;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;

public class DbConnection {

    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3308/officehoursmangementsystem";
        String pass = "root";
        String user = "root";
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return connection;
    }
}
