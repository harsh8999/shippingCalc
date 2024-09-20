package com.example.shippingcalc.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.shippingcalc.entity.Product;

@Repository
public class ProductRepo {

    Map<Integer, Product> products = new HashMap<>();

    public ProductRepo() {
        products.put(1, new Product(1, "Noodles", 10, 0.5f));
        products.put(2, new Product(2, "Rice Bag", 500, 10.0f));
        products.put(3, new Product(3, "Sugar Bag", 1000, 25.0f));
    }

    public Map<Integer, Product> getProducts() {
        return products;
    }

    public Product getProductById(int id) {
        return products.get(id);
    }


}
