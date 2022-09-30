package com.coderspace.todoapp.exception;

public class UsernamePasswordMissMatchException extends RuntimeException{
    public UsernamePasswordMissMatchException(String message) {
        super(message);
    }
}
