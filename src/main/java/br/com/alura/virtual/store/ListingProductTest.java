package br.com.alura.virtual.store;

import br.com.alura.virtual.store.dao.ProductDAO;
import br.com.alura.virtual.store.modelo.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListingProductTest {
    public static void main(String[] args) throws SQLException {
        List<Product> products = new ArrayList<>();
        try (Connection connection = new ConnectionFactory().returnConnection()) {
            ProductDAO productDAO = new ProductDAO(connection);
            products = productDAO.list();

            products.stream().forEach(lp -> System.out.println(lp));
        }

    }
}
