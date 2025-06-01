package com.carhub.carhub_backend.exception;

// Custom exception when a car is not found in the DB

public class CarNotFoundException extends RuntimeException {
    public CarNotFoundException(String message){
        super(message);
    }
}
