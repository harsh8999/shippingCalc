package com.example.shippingcalc.repository;

import java.util.HashMap;
import java.util.Map;

import com.example.shippingcalc.entity.WareHouse;


public class WareHouseRepo {

    Map<Integer, WareHouse> wareHouses = new HashMap<>();


    public WareHouseRepo() {
        wareHouses.put(1, new WareHouse(1, "BLR_Warehouse", 12.99999, 37.923273));
        wareHouses.put(2, new WareHouse(2, "MUMB_Warehouse", 11.99999, 27.923273));
    }

    public Map<Integer, WareHouse> getWareHouses() {
        return wareHouses;
    }

    public WareHouse getWareHouseById(int id) {
        return wareHouses.get(id);
    }
}
