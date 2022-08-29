package br.com.alura.virtual.store;

import br.com.alura.virtual.store.modelo.Product;

import java.sql.*;

public class InsertIntoWithProductTest {
    public static void main(String[] args) {
        Product product = new Product("Comoda", "Comoda Vertical");

        try(Connection connection = new ConnectionFactory().returnConnection()){
            String sql = "INSERT INTO PRODUCT (NAME, DESCRIPTION) VALUES (?, ?)";

            try(PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
               pstm.setString(1, product.getName());
               pstm.setString(2, product.getDescription());

               pstm.execute();

               try(ResultSet rst = pstm.getGeneratedKeys()){
                   while(rst.next()){
                       product.setId((rst.getInt(1)));
                   }
               }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
