package com.apram.employeemanagementapi.exception;


public class ResourceNotFoundException 
        extends RuntimeException {


    public ResourceNotFoundException(String message){

        super(message);

    }

}