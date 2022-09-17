package com.example.course_registrstion_system.service.impl;

import com.example.course_registrstion_system.entity.AuthorityPerson;
import com.example.course_registrstion_system.entity.Role;
import com.example.course_registrstion_system.exception.ApiException;
import com.example.course_registrstion_system.exception.ResourceNotFoundException;
import com.example.course_registrstion_system.payload.AppConstrain;
import com.example.course_registrstion_system.payload.AuthorityPersonDto;
import com.example.course_registrstion_system.payload.RoleDto;
import com.example.course_registrstion_system.repo.AuthorityPersonRepo;
import com.example.course_registrstion_system.repo.RoleRpo;
import com.example.course_registrstion_system.service.AuthorityPersonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class AuthorityPersonServiceImpl implements AuthorityPersonService {
    @Autowired
    private AuthorityPersonRepo authorityPersonRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RoleRpo roleRpo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public AuthorityPersonDto createAuthorityPerson(AuthorityPersonDto authorityPersonDto) {
        AuthorityPerson authorityPerson = this.modelMapper.map(authorityPersonDto, AuthorityPerson.class);

        authorityPerson.setPassword(this.passwordEncoder.encode(authorityPerson.getPassword()));

        Role role = this.roleRpo.findById(AppConstrain.ROLE_NORMAL).orElseThrow(() -> new ResourceNotFoundException("Role", "id", AppConstrain.ROLE_NORMAL));
        authorityPerson.getRoles().add(role);
        AuthorityPerson saveAuthorityPerson = this.authorityPersonRepo.save(authorityPerson);
        return this.modelMapper.map(saveAuthorityPerson,AuthorityPersonDto.class);
    }

    @Override
    public void deleteAuthorityPerson(int id) {
        AuthorityPerson authorityPerson = this.authorityPersonRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("AuthorityPerson", "id", id));
        this.authorityPersonRepo.delete(authorityPerson);
    }

    @Override
    public AuthorityPersonDto updateAuthorityPerson(AuthorityPersonDto authorityPersonDto, int id) {
        AuthorityPerson authorityPerson = this.authorityPersonRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("AuthorityPerson", "id", id));
        AuthorityPerson authorityPerson1 = this.modelMapper.map(authorityPersonDto, AuthorityPerson.class);
        authorityPerson.setName(authorityPerson1.getName());
        authorityPerson.setEmail(authorityPerson1.getEmail());
        authorityPerson.setPassword(authorityPerson1.getPassword());
        authorityPerson.setRoles(authorityPerson1.getRoles());
        AuthorityPerson saveAuthorityPerson = this.authorityPersonRepo.save(authorityPerson);
        return this.modelMapper.map(saveAuthorityPerson,AuthorityPersonDto.class);
    }

    @Override
    public AuthorityPersonDto getSingleAuthorityPerson(String email) {
        AuthorityPerson authorityPerson = this.authorityPersonRepo.findByEmail(email).orElseThrow();
        return  this.modelMapper.map(authorityPerson,AuthorityPersonDto.class);
    }
}
