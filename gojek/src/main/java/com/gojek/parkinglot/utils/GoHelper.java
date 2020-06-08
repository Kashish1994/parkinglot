package com.gojek.parkinglot.utils;

import com.gojek.parkinglot.constants.GoConstants;
import com.gojek.parkinglot.constants.Commands;
import com.gojek.parkinglot.domain.Car;
import com.gojek.parkinglot.exceptions.GoException;
import com.gojek.parkinglot.impl.ParkingServiceImpl;
import com.gojek.parkinglot.service.ParkingService;

public class GoHelper {
    public static boolean execute(String input) throws Exception {
        String[] inputCommand = GoHelper.resolveInput(input);
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
            case leave:
                parkingService.leaveCar(Integer.valueOf(inputCommand[1]));
                break;
            case status:
                parkingService.getParkingLotStatus();
                break;
            default:
                parkingService.query(inputCommand[0], inputCommand[1]);
        }

        if (input.equalsIgnoreCase(Commands.exit.toString())) {
            return true;
        }
        return false;
    }

    private static String[] resolveInput(String input) {
        if (input.equals("") || null == input) {
            throw new GoException("No Input detected");
        }
        return input.split(" ");
    }
}
