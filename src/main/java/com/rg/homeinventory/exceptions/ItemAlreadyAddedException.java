package com.rg.homeinventory.exceptions;


public class ItemAlreadyAddedException extends RuntimeException{
    public ItemAlreadyAddedException(String msg){
        super(msg);
    }
}
