package br.com.alura.virtual.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteTest {
    public static void main(String[] args) throws SQLException {
        String sql = "DELETE FROM PRODUCT WHERE ID > ?";

        ConnectionFactory cf = new ConnectionFactory();
        Connection conn = cf.returnConnection();

        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, 2);
        stm.execute();

        Integer modifiedRows = stm.getUpdateCount();

        System.out.println("Linhas modificadas: " + modifiedRows);

        stm.close();
        conn.close();
    }
}
