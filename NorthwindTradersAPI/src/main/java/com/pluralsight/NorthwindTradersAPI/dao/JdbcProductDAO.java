package com.pluralsight.NorthwindTradersAPI.dao;

import com.pluralsight.NorthwindTradersAPI.models.Product;

import java.util.List;

public class JdbcProductDAO implements ProductDAO {
    @Override
    public List<Product> getAllProducts() {

        String query = """
                 select
                                productId,
                                productName,
                                CategoryId,
                                UnitPrice
                                from
                                products
                """;


        return List.of();
    }

    @Override
    public Product getProductById(int productId) {
        String query = """
                select
                               productId,
                               productName,
                               CategoryId,
                               UnitPrice
                               from
                               products
                               WHERE ProductID = ?""";
        return null;
    }

    @Override
    public void addProduct(Product product) {
// we will do this later
    }
}
