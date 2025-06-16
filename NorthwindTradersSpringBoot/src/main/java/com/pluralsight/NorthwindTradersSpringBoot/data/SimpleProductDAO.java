package com.pluralsight.NorthwindTradersSpringBoot.data;

import com.pluralsight.NorthwindTradersSpringBoot.models.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class SimpleProductDAO implements ProductDAO {
    private List<Product> products = new ArrayList<>();
    //private HashMap<Integer, Product> products = new HashMap<Integer, Product>();

    public SimpleProductDAO(){
        //this.products.put(1, new Product(1,"Milk", "Food", 10.99 ));
        //this.products.put(2, new Product(2,"Apple", "Food", 1.99 ));
        //this.products.put(3, new Product(3,"Pant", "Clothing", 15.99 ));
        //this.products.put(4, new Product(4,"Shirt", "Clothing", 19.99 ));

        this.products.add(new Product(1,"Milk", "Food", 10.99 ));
        this.products.add(new Product(2,"Apple", "Food", 1.99 ));
        this.products.add(new Product(3,"Pant", "Clothing", 15.99 ));
        this.products.add(new Product(4,"Shirt", "Clothing", 19.99 ));
    }

    @Override
    public void add(Product product) {
        this.products.add(product);
    }

    @Override
    public List<Product> getAll() {
      //  return (List<Product>) this.products.values();
        return this.products;
    }



}
