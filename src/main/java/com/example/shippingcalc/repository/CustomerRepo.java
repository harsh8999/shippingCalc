package com.example.shippingcalc.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.shippingcalc.entity.Customer;

@Repository
public class CustomerRepo {
    Map<Integer, Customer> customers = new HashMap<>();

    public CustomerRepo() {
        customers.put(1, new Customer(1, "Shree Kirana Store"));
        customers.put(2, new Customer(2, "Andheri Mini Mart"));
    }

    public Map<Integer, Customer> getCustomers() {
        return customers;
    }

    public Customer getCustomerById(int id) {
        return customers.get(id);
    }
}
