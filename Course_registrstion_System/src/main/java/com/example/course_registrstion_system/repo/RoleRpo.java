package com.example.course_registrstion_system.repo;

import com.example.course_registrstion_system.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRpo extends JpaRepository<Role, Integer> {
}
