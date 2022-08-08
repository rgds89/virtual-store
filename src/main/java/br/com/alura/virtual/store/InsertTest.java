package br.com.alura.virtual.store;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {

    public static void main(String[] args) throws SQLException {
        ConnectionFactory cf = new ConnectionFactory();
        Connection conn = cf.returnConnection();

        Statement stm = conn.createStatement();
        stm.execute("INSERT INTO PRODUCT (NAME, DESCRIPTION) VALUES ('Mouse', 'Mouse sem fio')", Statement.RETURN_GENERATED_KEYS);

        ResultSet rst = stm.getGeneratedKeys();
        while(rst.next()){
            Integer id = rst.getInt(1);
            System.out.println("Id: " + id);
        }

        conn.close();
    }
}
