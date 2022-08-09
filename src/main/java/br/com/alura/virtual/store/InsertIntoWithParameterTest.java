package br.com.alura.virtual.store;

import java.sql.*;

public class InsertIntoWithParameterTest {
    public static void main(String[] args) throws SQLException {
        String name = "Mouse'";
        String desc = "Mouse usb";
        String sql = "INSERT INTO PRODUCT (NAME, DESCRIPTION) VALUES (?, ?)";
        ConnectionFactory cf = new ConnectionFactory();
        Connection conn = cf.returnConnection();
        conn.setAutoCommit(false);

        try {
            PreparedStatement stm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            addVariable("Smart TV", "45 Polegadas", stm);
            addVariable("Home Theater", "Edifier modelo 2323", stm);

            conn.commit();

            stm.close();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            throw new RuntimeException("Error preparing and inserting products");
        }
    }

    private static void addVariable(String name, String desc, PreparedStatement stm) throws SQLException {
        stm.setString(1, name);
        stm.setString(2, desc);
        stm.execute();

        ResultSet rst = stm.getGeneratedKeys();
        while (rst.next()) {
            Integer id = rst.getInt(1);
            System.out.println("Id: " + id);
        }
    }
}
