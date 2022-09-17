package com.example.course_registrstion_system.service;

import com.example.course_registrstion_system.payload.AuthorityPersonDto;

public interface AuthorityPersonService {
    AuthorityPersonDto createAuthorityPerson(AuthorityPersonDto authorityPersonDto);
    void deleteAuthorityPerson(int id);
    AuthorityPersonDto updateAuthorityPerson(AuthorityPersonDto authorityPersonDto,int id);

    AuthorityPersonDto getSingleAuthorityPerson(String email);
}
