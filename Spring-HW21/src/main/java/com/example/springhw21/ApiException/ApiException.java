package com.example.springhw21.ApiException;

public class ApiException extends  RuntimeException{
    public ApiException(String message){
        super(message);
    }
}
