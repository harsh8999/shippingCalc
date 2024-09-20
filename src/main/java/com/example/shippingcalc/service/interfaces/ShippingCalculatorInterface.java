package com.example.shippingcalc.service.interfaces;

import java.util.List;

public interface ShippingCalculatorInterface {

    double getShippingCharge(String transportMode, List<Integer> productIds, String deliveryTypes, double customerLatitude, double customerLongitude);

}
