package com.pluralsight.NorthwindTradersAPI.dao;

import com.pluralsight.NorthwindTradersAPI.models.Product;

import java.util.ArrayList;
import java.util.List;


public class SimpleProductDAO implements ProductDAO{


    @Override
    public List<Product> getAllProducts() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Milk", 1, 5.99));
        products.add(new Product(2, "Bread", 1, 5.99));
        products.add(new Product(3, "Water", 1, 5.99));
        products.add(new Product(4, "Pants", 2, 5.99));
        products.add(new Product(5, "TShirt", 2, 5.99));
        return products;
    }

    @Override
    public Product getProductById(int productId) {
        List<Product> allProducts = getAllProducts();
        return allProducts.stream().filter(p -> p.getProductId() == productId).findFirst().orElse(null);

    }

    @Override
    public Product addProduct(Product product) {
        //do nothing so far.
        return new Product();
    }
}
