package br.com.alura.virtual.store;

import java.sql.*;

public class InsertTest {

    public static void main(String[] args) throws SQLException {
        String sql = "INSERT INTO PRODUCT (NAME, DESCRIPTION) VALUES ('Mouse', 'Mouse sem fio')";
        ConnectionFactory cf = new ConnectionFactory();
        Connection conn = cf.returnConnection();

        PreparedStatement stm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stm.execute();

        ResultSet rst = stm.getGeneratedKeys();
        while (rst.next()) {
            Integer id = rst.getInt(1);
            System.out.println("Id: " + id);
        }

        conn.close();
    }
}
