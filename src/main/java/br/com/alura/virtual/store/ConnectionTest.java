package br.com.alura.virtual.store;

import java.sql.Connection;
import java.sql.SQLException;


public class ConnectionTest {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection con = connectionFactory.returnConnection();

        con.close();

    }
}
