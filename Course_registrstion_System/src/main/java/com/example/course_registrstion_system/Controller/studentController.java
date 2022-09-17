package com.example.course_registrstion_system.Controller;

import com.example.course_registrstion_system.payload.ApiResponce;
import com.example.course_registrstion_system.payload.StudentDto;
import com.example.course_registrstion_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin("*")
public class studentController {
    @Autowired
    private StudentService studentService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/")
    public ResponseEntity<StudentDto>createStudent(@Valid @RequestBody StudentDto studentDto){
        StudentDto student = this.studentService.createStudent(studentDto);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponce>deleteStudent(@PathVariable long id){
        this.studentService.deleteStudent(id);
        return new ResponseEntity<>(new ApiResponce("Student Deleted Successfully",true),HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<StudentDto>updateStudent(@Valid @RequestBody StudentDto studentDto,@PathVariable long id){
        StudentDto updateStudent = this.studentService.updateStudent(studentDto, id);
        return new ResponseEntity<StudentDto>(updateStudent,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto>getSingleStudent(@PathVariable long id){
        StudentDto singleUser = this.studentService.getSingleUser(id);
        return new ResponseEntity<StudentDto>(singleUser,HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<StudentDto>>getAllStudents(){
        return new ResponseEntity<List<StudentDto>>(this.studentService.getAllStudent(),HttpStatus.OK);
    }
}
