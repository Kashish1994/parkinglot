package com.gojek.parkinglot.service;

import com.gojek.parkinglot.domain.Car;

public interface ParkingService {
    void createParkingLot(int slots) throws Exception;
    void parkCar(Car car) throws Exception;
    void leaveCar(int slotNumber) throws Exception;
    void getParkingLotStatus() throws Exception;
    void query(String cmd, String query)throws Exception;
}
