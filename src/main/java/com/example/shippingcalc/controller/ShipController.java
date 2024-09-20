package com.example.shippingcalc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shippingcalc.controller.exchanges.RequestData;
import com.example.shippingcalc.service.implementations.ShippingCalculator;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/shipping-charge")
@AllArgsConstructor
public class ShipController {

    private ShippingCalculator shippingCalculator;

    @GetMapping("/calculate")
    public ResponseEntity<Double> getMethodName(@RequestBody RequestData data) {
        double ans = shippingCalculator.getShippingCharge(data.getTransportMode(),data.getProductIds(), data.getDeliveryTypes(), data.getCustomerLatitude(),data.getCustomerLongitude());
        return new ResponseEntity<>(ans, HttpStatus.OK);
    }
    
}
