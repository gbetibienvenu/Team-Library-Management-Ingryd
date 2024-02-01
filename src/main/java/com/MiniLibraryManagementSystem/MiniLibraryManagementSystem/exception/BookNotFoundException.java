package com.MiniLibraryManagementSystem.MiniLibraryManagementSystem.exception;

public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException(String message){
        super(message);
    }
}
