package br.com.alura.virtual.store;

import java.sql.*;

public class ListingTest {

    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/VIRTUAL_STORE?useTimezone=true&serverTimezone=UTC", "root", "Fpcci#2022");

        Statement stm = con.createStatement();
        boolean result =  stm.execute("SELECT ID, NAME, DESCRIPTION FROM PRODUCT");

        ResultSet resultSet = stm.getResultSet();

        while (resultSet.next()){
            Integer id = resultSet.getInt("ID");
            System.out.println("Id: " + id);

            String name = resultSet.getString("NAME");
            System.out.println("Name: " + name);

            String desc = resultSet.getString("DESCRIPTION");
            System.out.println("Desc: " + desc);
        }

        System.out.println(result);

        con.close();

    }
}
