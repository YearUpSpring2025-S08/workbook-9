package com.pluralsight.NorthwindTradersAPI.controllers;


import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductsController {

    @RequestMapping(path="/products", method = RequestMethod.GET)
    public List<Product> getProducts(){
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Milk", 1, 5.99));
        products.add(new Product(2, "Bread", 1, 5.99));
        products.add(new Product(3, "Water", 1, 5.99));
        products.add(new Product(4, "Pants", 2, 5.99));
        products.add(new Product(5, "TShirt", 2, 5.99));
        return products;
    }



    @RequestMapping(path="/products/{id}", method = RequestMethod.GET)
    public List<Product> getProducts( @PathVariable int id){
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Milk", 1, 5.99));
        products.add(new Product(2, "Bread", 1, 5.99));
        products.add(new Product(3, "Water", 1, 5.99));
        products.add(new Product(4, "Pants", 2, 5.99));
        products.add(new Product(5, "TShirt", 2, 5.99));


        ArrayList<Product> resultingProducts = new ArrayList<>();
        for(Product p : products){
            if(p.getProductId() == id){
                resultingProducts.add(p);
            }
        }
        return resultingProducts;

    }

    @RequestMapping(path="/products/byName/{productName}", method = RequestMethod.GET)
    public List<Product> getProducts( @PathVariable String productName){
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Milk", 1, 5.99));
        products.add(new Product(2, "Bread", 1, 5.99));
        products.add(new Product(3, "Water", 1, 5.99));
        products.add(new Product(4, "Pants", 2, 5.99));
        products.add(new Product(5, "TShirt", 2, 5.99));

        return products.stream().filter(p -> p.getProductName().equalsIgnoreCase(productName)).toList();


    }
}
