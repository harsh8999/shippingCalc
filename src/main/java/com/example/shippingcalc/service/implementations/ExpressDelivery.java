package com.example.shippingcalc.service.implementations;

import org.springframework.stereotype.Service;

import com.example.shippingcalc.service.interfaces.DeliveryTypesStrategy;

@Service
public class ExpressDelivery implements DeliveryTypesStrategy {

    @Override
    public double calculateShippingCost(double weight, double baseShippingCost, double distance) {
        // Express charge Rs 10 + Rs 1.2 per Kg + Rs 0.5 per Km + base calculated shipping charge
        return 10 + (1.2 * weight) + (0.5 * distance) + baseShippingCost;
    }
}