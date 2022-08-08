package br.com.alura.virtual.store;

import java.sql.*;

public class InsertIntoWithParameterTest {
    public static void main(String[] args) throws SQLException {
        String name = "Mouse'";
        String desc = "Mouse usb";
        String sql = "INSERT INTO PRODUCT (NAME, DESCRIPTION) VALUES (?, ?)";
        ConnectionFactory cf = new ConnectionFactory();
        Connection conn = cf.returnConnection();

        PreparedStatement stm = conn.prepareStatement(sql,  Statement.RETURN_GENERATED_KEYS);
        stm.setString(1, name);
        stm.setString(2, desc);
        stm.execute();

        ResultSet rst = stm.getGeneratedKeys();
        while(rst.next()){
            Integer id = rst.getInt(1);
            System.out.println("Id: " + id);
        }

        conn.close();
    }
}
