package com.servicedata.error;

public class StudentNotFoundException extends Exception{
    public StudentNotFoundException(String message){
        super(message);
    }
}
