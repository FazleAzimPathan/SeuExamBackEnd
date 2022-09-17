package com.example.course_registrstion_system.repo;

import com.example.course_registrstion_system.entity.AuthorityPerson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorityPersonRepo extends JpaRepository<AuthorityPerson,Integer> {
    Optional<AuthorityPerson> findByEmail(String email);
}
