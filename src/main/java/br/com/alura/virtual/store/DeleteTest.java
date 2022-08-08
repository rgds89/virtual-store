package br.com.alura.virtual.store;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTest {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory cf = new ConnectionFactory();
        Connection conn = cf.returnConnection();

        Statement stm = conn.createStatement();
        stm.execute("DELETE FROM PRODUCT WHERE ID > 2");

        Integer modifiedRows = stm.getUpdateCount();

        System.out.println("Linhas modificadas: " + modifiedRows);


        conn.close();
    }
}
