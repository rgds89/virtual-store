package br.com.alura.virtual.store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionTest {
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/VIRTUAL_STORE?useTimezone=true&serverTimezone=UTC", "root", "Fpcci#2022");

        con.close();

    }
}
