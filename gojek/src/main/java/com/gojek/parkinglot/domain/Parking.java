package com.gojek.parkinglot.domain;

import com.gojek.parkinglot.constants.GoConstants;

public class Parking {
    private static Parking parking_single_instance = null;
    private static boolean initialized = false;
    private Slot slots[] = null;

    private Parking(int totalSlots) {
        this.totalSlots = totalSlots;
    }

    public static Parking getInstance(int totalSlots, boolean throwIfExist) throws Exception {
        if (initialized && throwIfExist) {
            String message = "Parking lot exists with capacity " + totalSlots;
            System.out.println(message);
            throw new Exception(message);
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
        for (int i = 0; i < slots.length; i++) {
            String state = GoConstants.EMPTY.toString();
            if (!slots[i].isEmpty()) {
                state = GoConstants.OCCUPIED.toString() + " with " + slots[i].getCar().getRegId();
            }
            System.out.println("Slot number " + slots[i].getSlotNumber() + " is " + state);
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
        this.printSlotDetails();
        if (isParked) {
            System.out.println("Allotted slot number: " + slotNumber);
        } else {
            System.out.println("Sorry ! Parking lot is full");
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

    public void updateSlotInfo(Slot info, int slotNumber) {
        Slot slots[] = this.getSlots();

    }
}
