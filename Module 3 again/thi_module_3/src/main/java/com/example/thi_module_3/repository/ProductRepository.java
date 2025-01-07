package com.example.thi_module_3.repository;

import com.example.thi_module_3.model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private static final List<Product> products = new ArrayList<>();

    public List<Product> getAll() {
        PreparedStatement statement = null;
        List<Product> products = new ArrayList<>();
        try {
            statement = BaseRepository.getConnection().
                    prepareStatement("select * from products");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                double discountRate = resultSet.getDouble("discount_rate");
                int stockQuantity = resultSet.getInt("stock_quantity");
                products.add(new Product(id, name, price, discountRate, stockQuantity));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }

    public void create(Product product) {
        String sql = "insert into products (name, price, discount_rate, stock_quantity) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = BaseRepository.getConnection().prepareStatement(sql)) {
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setDouble(3, product.getDiscountRate());
            statement.setInt(4, product.getStockQuantity());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error: " + e.getMessage(), e);
        }
    }

}
