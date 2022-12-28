package com.rg.homeinventory.exceptions;


public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(String msg){
        super(msg);
    }
}
