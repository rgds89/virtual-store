package br.com.alura.virtual.store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection returnConnection() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/VIRTUAL_STORE?useTimezone=true&serverTimezone=UTC", "root", "Fpcci#2022");

        return con;
    }
}
