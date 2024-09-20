package com.example.shippingcalc.entity;

public enum TransportMode {

    AEROPLANE(1), 
    TRUCK(2), 
    MINIVAN(3);

    private final int ratePerKm;

    // Constructor to initialize ratePerKm
    TransportMode(int ratePerKm) {
        this.ratePerKm = ratePerKm;
    }

    // Getter to retrieve the rate per kilometer
    public int getRatePerKm() {
        return ratePerKm;
    }

}
