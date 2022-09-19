package br.com.alura.virtual.store;

import br.com.alura.virtual.store.dao.CategoryDAO;
import br.com.alura.virtual.store.dao.ProductDAO;
import br.com.alura.virtual.store.modelo.Category;
import br.com.alura.virtual.store.modelo.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListingCategoryTest {
    public static void main(String[] args) throws SQLException {
        List<Category> categories = new ArrayList<>();
        try(Connection connection = new ConnectionFactory().returnConnection()){
            CategoryDAO categoryDAO = new CategoryDAO(connection);
            categories = categoryDAO.list();

            categories.stream().forEach(lc -> {
                System.out.println(lc.getName());

                for(Product product : new ProductDAO(connection).getProductByCategory(lc)){
                    System.out.println(lc.getName() + " - " + product.getName());
                }
            });
        }
    }
}
