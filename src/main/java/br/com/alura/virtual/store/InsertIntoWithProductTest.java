package br.com.alura.virtual.store;

import br.com.alura.virtual.store.dao.ProductDAO;
import br.com.alura.virtual.store.modelo.Product;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertIntoWithProductTest {
    public static void main(String[] args) {
        Product product = new Product("Comoda", "Comoda Vertical", 4);

        try (Connection connection = new ConnectionFactory().returnConnection()) {
            new ProductDAO(connection).save(product);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
