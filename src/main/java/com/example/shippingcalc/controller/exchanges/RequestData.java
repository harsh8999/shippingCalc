package com.example.shippingcalc.controller.exchanges;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestData {

    String transportMode; 
    List<Integer> productIds; 
    String deliveryTypes;
    double customerLatitude; 
    double customerLongitude;

}
