package com.gojek.parkinglot.service;

import com.gojek.parkinglot.domain.Car;

public interface ParkingService {
    void createParkingLot(int slots) throws Exception;
    void parkCar(Car car) throws Exception;
}
