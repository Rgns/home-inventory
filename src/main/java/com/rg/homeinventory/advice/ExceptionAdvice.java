package com.rg.homeinventory.advice;


import com.rg.homeinventory.exceptions.ErrorDetails;
import com.rg.homeinventory.exceptions.ItemAlreadyAddedException;
import com.rg.homeinventory.exceptions.ItemNotFoundException;
import com.rg.homeinventory.exceptions.UnknownItemException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.HashMap;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(ItemAlreadyAddedException.class)
    protected ResponseEntity<ErrorDetails> exception1(ItemAlreadyAddedException ex) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(),"Bad Req exception" , ex.getMessage() );
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ItemNotFoundException.class)
    protected ResponseEntity<ErrorDetails> exception2(ItemNotFoundException ex) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(),"Bad Req exception" , ex.getMessage() );
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnknownItemException.class)
    protected ResponseEntity<ErrorDetails> exception3(UnknownItemException ex) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(),"Bad Req exception" , ex.getMessage() );
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<HashMap<String,ErrorDetails>> exception4(MethodArgumentNotValidException ex) {
        HashMap<String,ErrorDetails> map = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
            map.put(fieldError.getField(),  new ErrorDetails(new Date(),"Bad Req exception" , fieldError.getDefaultMessage()) );
        });
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }
}
