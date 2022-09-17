package com.example.course_registrstion_system.repo;

import com.example.course_registrstion_system.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Long> {
}
