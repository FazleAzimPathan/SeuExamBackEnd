package com.example.course_registrstion_system.exception;

public class ApiException extends RuntimeException{
    public ApiException(String message) {
        super(message);
    }

    public ApiException() {
        super();
    }
}
