package com.telerikacademy.agency.models.vehicles.contracts;

import com.telerikacademy.agency.models.common.VehicleType;

public interface Train extends Vehicle {
    int MIN_NUM_CARTS = 1;
    int MAX_NUM_CARTS = 15;

    int getCarts();
}
