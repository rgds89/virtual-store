package br.com.alura.virtual.store.dao;

import br.com.alura.virtual.store.modelo.Product;

import java.sql.*;

public class ProductDAO {
    private Connection connection;

    public ProductDAO(Connection conn) {
        this.connection = conn;
    }

    public void save(Product product) {
        String sql = "INSERT INTO PRODUCT (NAME, DESCRIPTION) VALUES (?, ?)";

        try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstm.setString(1, product.getName());
            pstm.setString(2, product.getDescription());

            pstm.execute();

            try (ResultSet rst = pstm.getGeneratedKeys()) {
                while (rst.next()) {
                    product.setId((rst.getInt(1)));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
