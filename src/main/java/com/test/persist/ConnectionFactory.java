package com.test.persist;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
public class ConnectionFactory {
    private static final String JDBC_URL = "jdbc:mysql://localhost/thiamaco";
    private static final String JDBC_USER = "thiamaco";
    private static final String JDBC_PASSWORD = "thiamaco";
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver JDBC não encontrado", e);
        }
    }

}
