package com.gojek.parkinglot.exceptions;

public class GoException extends RuntimeException{
    public GoException(String errorMessage){
        super(errorMessage);
    }
}
