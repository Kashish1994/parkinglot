package com.gojek.parkinglot.impl;

import com.gojek.parkinglot.domain.Car;
import com.gojek.parkinglot.domain.Parking;
import com.gojek.parkinglot.domain.Slot;
import com.gojek.parkinglot.service.ParkingService;

public class ParkingServiceImpl implements ParkingService {

    @Override
    public void createParkingLot(int parkingSlots) throws Exception {
        Parking parking = Parking.getInstance(parkingSlots, true);
        this.createSlots(parking);
    }

    @Override
    public void parkCar(Car car) throws Exception {
        Parking parking = Parking.getInstance(0, false);
        parking.parkCar(car);
    }

    @Override
    public void leaveCar(int slotNumber) throws Exception {
        Parking parking = Parking.getInstance(0, false);
        parking.leaveCar(slotNumber);
    }

    private void createSlots(Parking parking) {
        Slot[] slots = new Slot[parking.getTotalSlots()];
        int slotNumber = 1;
        while (slotNumber <= parking.getTotalSlots()) {
            Slot slot = new Slot(slotNumber, true, null);
            slots[slotNumber - 1] = slot;
            slotNumber++;
        }
        parking.setSlots(slots);
    }

    @Override
    public void getParkingLotStatus() throws Exception {
        Parking.getInstance(0, false).printSlotDetails();
    }

    @Override
    public void query(String cmd, String query) throws Exception{
        Parking.getInstance(0, false).queryParkingLot(cmd,query);

    }
}
