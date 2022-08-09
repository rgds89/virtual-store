package br.com.alura.virtual.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListingTest {
    public static void main(String[] args) throws SQLException {
        String sql = "SELECT ID, NAME, DESCRIPTION FROM PRODUCT";

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection con = connectionFactory.returnConnection();

        PreparedStatement stm = con.prepareStatement(sql);
        stm.execute();

        ResultSet resultSet = stm.getResultSet();

        while (resultSet.next()) {
            Integer id = resultSet.getInt("ID");
            System.out.println("Id: " + id);

            String name = resultSet.getString("NAME");
            System.out.println("Name: " + name);

            String desc = resultSet.getString("DESCRIPTION");
            System.out.println("Desc: " + desc);
        }

        con.close();

    }
}
