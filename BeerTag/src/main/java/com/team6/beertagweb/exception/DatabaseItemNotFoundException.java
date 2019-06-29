package com.team6.beertagweb.exception;

public class DatabaseItemNotFoundException extends RuntimeException  {

    public DatabaseItemNotFoundException(int id){
        super(String.format("Item with Id %d not found.", id));

    }
}
