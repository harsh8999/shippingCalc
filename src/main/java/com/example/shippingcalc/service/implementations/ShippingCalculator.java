package com.example.shippingcalc.service.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.shippingcalc.entity.WareHouse;
import com.example.shippingcalc.repository.ProductRepo;
import com.example.shippingcalc.repository.WareHouseRepo;
import com.example.shippingcalc.service.interfaces.DeliveryTypesStrategy;
import com.example.shippingcalc.service.interfaces.ShippingCalculatorInterface;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ShippingCalculator implements ShippingCalculatorInterface {

    private ProductRepo productRepo;
    private DeliveryTypesStrategy deliveryTypesStrategy;

    @Override
    public double getShippingCharge(String transportMode, List<Integer> productIds, String deliveryTypes,
            double customerLatitude, double customerLongitude) {

            DeliveryTypesStrategy deliveryTypeStrategy = DeliveryTypeStrategyFactory.getDeliveryTypeStrategy(deliveryTypes);
        
            double productPrice = 0;
            double weight = 0;
                

            for(Integer id : productIds) {
                weight += productRepo.getProductById(id).getWeight();
                productPrice += productRepo.getProductById(id).getPrice();
            }

            WareHouse nearestWarehouse = getNearestWarehouse(customerLatitude, customerLongitude);
            double distance = calculateDistance(nearestWarehouse.getLatitude(), nearestWarehouse.getLongitude(), 
                                                customerLatitude, customerLongitude);
            
            // Use distance in your shipping cost calculation if needed
            return deliveryTypesStrategy.calculateShippingCost(weight, productPrice, distance);
        

    }

    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Radius of the Earth in kilometers
    
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
                   Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                   Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    
        return R * c; // Distance in kilometers
    }

    private WareHouse getNearestWarehouse(double customerLatitude, double customerLongitude) {
    WareHouseRepo wareHouseRepo = new WareHouseRepo(); // Instantiate the repository
    WareHouse nearestWarehouse = null;
    double minDistance = Double.MAX_VALUE;

    for (WareHouse warehouse : wareHouseRepo.getWareHouses().values()) {
        double distance = calculateDistance(customerLatitude, customerLongitude,
                                            warehouse.getLatitude(), warehouse.getLongitude());
        if (distance < minDistance) {
            minDistance = distance;
            nearestWarehouse = warehouse;
        }
    }

    return nearestWarehouse;
}

}
