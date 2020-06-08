package com.gojek.parkinglot.domain;

import com.gojek.parkinglot.constants.Commands;
import com.gojek.parkinglot.exceptions.GoException;

public class Parking {
    private static Parking parking_single_instance = null;
    private static boolean initialized = false;
    private Slot slots[] = null;

    private Parking(int totalSlots) {
        this.totalSlots = totalSlots;
    }

    public static Parking getInstance(int totalSlots, boolean throwIfExist) throws Exception {
        if (initialized && throwIfExist) {
            String message = "Parking lot already exists " + totalSlots;
            System.out.println(message);
            throw new GoException("Parking lot exists with !");
        }
        if (parking_single_instance == null) {
            initialized = true;
            parking_single_instance = new Parking(totalSlots);
            System.out.println("Parking lot created with slots " + totalSlots);
        }
        return parking_single_instance;
    }

    public void printSlotDetails() {
        Slot slots[] = this.getSlots();
        System.out.println("Slot No.|, \"Registeration No()        | \"Color");
        for (int i = 0; i < slots.length; i++) {
            if (!slots[i].isEmpty()) {
                System.out.println(String.valueOf(slots[i].getSlotNumber()) + "        |        " +
                        slots[i].getCar().getRegId() + "          |   " + slots[i].getCar().getColor());
            }
        }

    }

    public void parkCar(Car car) {
        Slot slots[] = this.getSlots();
        boolean isParked = false;
        int slotNumber = 0;
        for (int i = 0; i < slots.length; i++) {
            Slot slot = slots[i];
            if (slot.isEmpty()) {
                slot.setEmpty(true);
                slot.setCar(car);
                slot.setEmpty(false);
                isParked = true;
                slotNumber = slot.getSlotNumber();
                slots[i] = slot;
                this.setSlots(slots);
                break;
            }
        }
        if (isParked) {
            System.out.println("Allotted slot number: " + slotNumber);
        } else {
            System.out.println("Sorry ! Parking lot is full");
        }
    }

    public void leaveCar(int slotNumberToRemoveFrom) {
        Slot slots[] = this.getSlots();
        boolean carLeft = false;
        for (int i = 0; i < slots.length; i++) {
            int slotNumber = slots[i].getSlotNumber();
            Slot slot = slots[i];
            if (slotNumber == slotNumberToRemoveFrom && !slot.isEmpty()) {
                slot.setEmpty(true);
                slot.setCar(null);
                slots[i] = slot;
                this.setSlots(slots);
                carLeft = true;
                break;
            }
        }
        if (carLeft) {
            System.out.println("Slot Number " + slotNumberToRemoveFrom + " is Free!!");
        } else {
            System.out.println("No Car parked at slot number " + slotNumberToRemoveFrom);
        }
    }

    public void queryParkingLot(String cmd, String query) {
        if (cmd.equals(Commands.registration_numbers_for_cars_with_colour.toString())) {
            this.filterSlotsByColor(query);
        } else if (cmd.equals(Commands.slot_number_for_registration_number.toString())) {
            this.filterSlotsByRegId(query);
        } else if (cmd.equals(Commands.slot_numbers_for_cars_with_colour.toString())) {
            this.filterByCarColor(query);
        } else {
            throw new GoException("Command not supported " + cmd);
        }
    }

    private void filterSlotsByColor(String color) {
        for (int i = 0; i < slots.length; i++) {
            Slot slot = slots[i];
            if (slot.getCar() != null && slot.getCar().getColor().equalsIgnoreCase(color)) {
                System.out.print(slot.getCar().getRegId() + ",");
            }
            System.out.println();
        }
    }

    private void filterSlotsByRegId(String regId) {
        for (int i = 0; i < slots.length; i++) {
            Slot slot = slots[i];
            if (slot.getCar() != null && slot.getCar().getRegId().equalsIgnoreCase(regId)) {
                System.out.println(slot.getSlotNumber());
            }
            System.out.println();
        }
    }

    private void filterByCarColor(String carColor) {
        for (int i = 0; i < slots.length; i++) {
            Slot slot = slots[i];
            if (slot.getCar() != null && slot.getCar().getColor().equalsIgnoreCase(carColor)) {
                System.out.print(slot.getSlotNumber() + ",");
            }
        }
    }

    private int totalSlots;

    public int getTotalSlots() {
        return totalSlots;
    }

    public void setTotalSlots(int totalSlots) {
        this.totalSlots = totalSlots;
    }

    public Slot[] getSlots() {
        return slots;
    }

    public void setSlots(Slot[] slots) {
        this.slots = slots;
    }
}
