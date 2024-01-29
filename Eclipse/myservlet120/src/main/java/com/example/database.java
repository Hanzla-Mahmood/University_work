package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {
    String url="jdbc:mysql://localhost:3306/uuniversity";
    String user="root";
    String password="595877";

    public Connection concet() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
}
