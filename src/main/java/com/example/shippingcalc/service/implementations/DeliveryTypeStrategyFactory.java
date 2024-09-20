package com.example.shippingcalc.service.implementations;

import org.springframework.stereotype.Service;

import com.example.shippingcalc.service.interfaces.DeliveryTypesStrategy;

@Service
public class DeliveryTypeStrategyFactory {

    static DeliveryTypesStrategy getDeliveryTypeStrategy(String name) {
        if(name.equalsIgnoreCase("express")) {
            return new ExpressDelivery();
        }
        if(name.equalsIgnoreCase("standard")) {
            return new StandardDelivery();
        }
        // Return null or throw an exception if no match is found
        throw new IllegalArgumentException("Invalid delivery type: " + name);
    }

}
