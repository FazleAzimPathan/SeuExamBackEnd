package com.example.course_registrstion_system.payload;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class StudentDto {
    private Long id;
    @NotEmpty
    @Size(min = 4,message = "Name must be min of 4 characters")
    private String name;
    @NotEmpty
    private String address;
    @NotEmpty
    private String gender;
    @NotEmpty
    private String instituteName;
}
