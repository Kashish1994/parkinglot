package com.gojek.parkinglot.domain;

public class Car {
    public Car(String color, String regId){
        this.color=color;
        this.regId=regId;
    }
    private String color;
    private String regId;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }
}
