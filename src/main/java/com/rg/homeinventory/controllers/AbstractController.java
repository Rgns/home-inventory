package com.rg.homeinventory.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.ArrayList;
import java.util.List;

import static com.rg.homeinventory.utils.Constants.HttpHeaderValues.MAX_AGE;
import static java.util.Collections.singletonList;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpMethod.*;

public abstract class AbstractController {

    protected <T> ResponseEntity<T> getResponse(final T entity , final HttpStatus status){
        return buildResponseEntity(entity,null, status);
    }

    private <T> ResponseEntity<T> buildResponseEntity(final T entity, HttpHeaders httpHeaders, final HttpStatus status) {
        if(httpHeaders == null){
            httpHeaders = new HttpHeaders();
        }
        httpHeaders.setAccessControlMaxAge(MAX_AGE);
        httpHeaders.setAccessControlAllowHeaders(singletonList(AUTHORIZATION));
        httpHeaders.setAccessControlAllowMethods(getHttpAllowedHeaders());
        return new ResponseEntity<>(entity,httpHeaders,status);
    }

    private List<HttpMethod> getHttpAllowedHeaders() {
        List<HttpMethod> list = new ArrayList<>();
        list.add(OPTIONS);
        list.add(HEAD);
        list.add(PUT);
        list.add(POST);
        list.add(DELETE);
        list.add(PATCH);
        list.add(GET);
        return list;
    }
}
