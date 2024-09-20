package com.example.shippingcalc.service.interfaces;

public interface DeliveryTypesStrategy {
    double calculateShippingCost(double weight, double baseShippingCost, double distance);
}
