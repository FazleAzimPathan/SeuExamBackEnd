package com.example.course_registrstion_system.exception;

public class ResourceNotFoundException extends RuntimeException{
    private String recourceName;
    private String fieldName;

    public ResourceNotFoundException(String recourceName, String fieldName,long fieldValue) {
        super(String.format("%s is not found with this %s : %s",recourceName,fieldName,fieldValue));
        this.recourceName = recourceName;
        this.fieldName = fieldName;
    }
}
