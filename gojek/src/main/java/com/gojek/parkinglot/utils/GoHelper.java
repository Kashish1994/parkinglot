package com.gojek.parkinglot.utils;

import com.gojek.parkinglot.constants.GoConstants;
import com.gojek.parkinglot.constants.Commands;
import com.gojek.parkinglot.domain.Car;
import com.gojek.parkinglot.impl.ParkingServiceImpl;
import com.gojek.parkinglot.service.ParkingService;

public class GoHelper {
    public static boolean execute(String input) throws Exception{
        String []inputCommand = GoHelper.resolveInput(input);
        Commands command = Commands.valueOf(inputCommand[0]);
        ParkingService parkingService = new ParkingServiceImpl();
        switch (command) {
            case create_parking_lot:
                int totalSlots = Integer.valueOf(inputCommand[1]);
                parkingService.createParkingLot(Integer.valueOf(totalSlots));
                break;
            case park:
                Car car = new Car(inputCommand[2], inputCommand[1]);
                parkingService.parkCar(car);
                break;
        }

        if (input.equals(GoConstants.EXIT)) {
            return true;
        }
        return false;
    }
    private static String[] resolveInput(String input){
        return input.split(" ");
    }
}
