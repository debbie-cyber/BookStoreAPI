package com.prunny.api.core.exception;

import lombok.Getter;

@Getter
public class BookStoreException extends Exception{
    private String message;
    public BookStoreException(String message){
        super(message);
        this.message = message;
    }
}
