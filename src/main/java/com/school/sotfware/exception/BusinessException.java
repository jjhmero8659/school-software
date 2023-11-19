package com.school.sotfware.exception;

public class BusinessException extends RuntimeException{
    protected BusinessException(String message) {
        super(message);
    }
}
