package com.gojek.parkinglot.domain;

public class Slot {
    private int slotNumber;
    private boolean isEmpty;
    private Car car;

    public Slot(int slotNumber, boolean isEmpty, Car car){
        this.car = car;
        this.isEmpty = isEmpty;
        this.slotNumber = slotNumber;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
