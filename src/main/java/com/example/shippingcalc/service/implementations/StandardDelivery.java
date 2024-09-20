package com.example.shippingcalc.service.implementations;

import org.springframework.stereotype.Service;

import com.example.shippingcalc.service.interfaces.DeliveryTypesStrategy;

@Service
public class StandardDelivery implements DeliveryTypesStrategy {

    @Override
    public double calculateShippingCost(double weight, double baseShippingCost, double distance) {
        // Standard charge Rs 10 + Rs 0.2 per Km + base calculated shipping charge
        return 10 + (0.2 * distance) + baseShippingCost;
    }

}
