package com.example.course_registrstion_system.security;

import com.example.course_registrstion_system.entity.AuthorityPerson;
import com.example.course_registrstion_system.exception.ResourceNotFoundException;
import com.example.course_registrstion_system.repo.AuthorityPersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private AuthorityPersonRepo authorityPersonRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthorityPerson user = this.authorityPersonRepo.findByEmail(username).orElseThrow(() -> new ResourceNotFoundException("user", "email: " + username, 0));
        return user;
    }
}
