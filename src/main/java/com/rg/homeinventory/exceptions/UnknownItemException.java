package com.rg.homeinventory.exceptions;


public class UnknownItemException extends RuntimeException{
    public UnknownItemException(String msg){
        super(msg);
    }
}
