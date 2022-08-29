package br.com.alura.virtual.store;

import java.sql.SQLException;

public class PoolConnectionTest {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory cf = new ConnectionFactory();

        for (int i=0; i<20; i++){
            cf.returnConnection();
            System.out.println("Conexão de número: " +i);
        }
    }
}
