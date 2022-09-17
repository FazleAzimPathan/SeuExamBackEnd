package com.example.course_registrstion_system.service.impl;

import com.example.course_registrstion_system.entity.Student;
import com.example.course_registrstion_system.exception.ResourceNotFoundException;
import com.example.course_registrstion_system.payload.StudentDto;
import com.example.course_registrstion_system.repo.StudentRepo;
import com.example.course_registrstion_system.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = this.modelMapper.map(studentDto, Student.class);
        Student saveStudent = this.studentRepo.save(student);
        return this.modelMapper.map(saveStudent, StudentDto.class);
    }

    @Override
    public void deleteStudent(long id) {
        Student student = this.studentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));
        this.studentRepo.delete(student);
    }

    @Override
    public StudentDto updateStudent(StudentDto studentDto, long id) {
        Student student = this.studentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));
        student.setName(studentDto.getName());
        student.setGender(studentDto.getGender());
        student.setAddress(studentDto.getAddress());
        student.setInstituteName(studentDto.getInstituteName());
        Student updateStudent = this.studentRepo.save(student);
        return this.modelMapper.map(updateStudent, StudentDto.class);
    }

    @Override
    public StudentDto getSingleUser(long id) {
        Student student = this.studentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student", "Id", id));
        return this.modelMapper.map(student, StudentDto.class);
    }

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> students = this.studentRepo.findAll();
        List<StudentDto> studentDtos = students.stream().map(student -> this.modelMapper.map(student, StudentDto.class)).collect(Collectors.toList());
        return studentDtos;
    }


}
