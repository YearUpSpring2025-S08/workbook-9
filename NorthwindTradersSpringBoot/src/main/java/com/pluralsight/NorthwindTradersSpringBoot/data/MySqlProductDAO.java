package com.pluralsight.NorthwindTradersSpringBoot.data;

import com.pluralsight.NorthwindTradersSpringBoot.models.Product;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class MySqlProductDAO implements ProductDAO {

    private DatabaseConfig databaseConfig;

    @Autowired
    public MySqlProductDAO(DatabaseConfig databaseConfig) {
        this.databaseConfig = databaseConfig;
    }

    @Override
    public void add(Product product) {
//do later.
    }

    @Override
    public List<Product> getAll() {
        ArrayList<Product> products = new ArrayList<>();
        BasicDataSource bds = new BasicDataSource();
        bds.setUsername(databaseConfig.getUsername());
        bds.setPassword(databaseConfig.getPassword());
        bds.setUrl(databaseConfig.getUrl());

        String query = """
                select
                productId,
                productName,
                CategoryName,
                UnitPrice
                from
                products
                join categories on products.CategoryID = categories.CategoryID""";

        try(Connection connection = bds.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
        ){
            while (resultSet.next()){
                int productId = resultSet.getInt(1);
                String productName = resultSet.getString(2);
                String categoryName = resultSet.getString(3);
                double price = resultSet.getDouble(4);
                Product p = new Product(productId, productName, categoryName, price);
                products.add(p);
            }

        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

        return products;

    }
}
