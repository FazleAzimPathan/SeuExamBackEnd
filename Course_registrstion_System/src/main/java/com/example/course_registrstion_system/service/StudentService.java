package com.example.course_registrstion_system.service;

import com.example.course_registrstion_system.entity.Student;
import com.example.course_registrstion_system.payload.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto createStudent(StudentDto studentDto);
    void deleteStudent(long id);
    StudentDto updateStudent(StudentDto studentDto,long id);
    StudentDto getSingleUser(long id);
    List<StudentDto>getAllStudent();
}
