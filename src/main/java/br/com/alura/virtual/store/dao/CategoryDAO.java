package br.com.alura.virtual.store.dao;

import br.com.alura.virtual.store.modelo.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    private final Connection connection;

    public CategoryDAO(Connection conn) {
        this.connection = conn;
    }

    public List<Category> list() {
        List<Category> categories = new ArrayList<>();

        String sql = "SELECT ID, NAME FROM CATEGORY";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.execute();

            try (ResultSet rst = pstm.getResultSet()) {
                while (rst.next()) {
                    Category category = new Category(rst.getInt(1), rst.getString(2));
                    categories.add(category);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }
}
