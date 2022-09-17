package com.example.course_registrstion_system.Controller;

import com.example.course_registrstion_system.payload.ApiResponce;
import com.example.course_registrstion_system.payload.AuthorityPersonDto;
import com.example.course_registrstion_system.service.AuthorityPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/authorityPerson")
@CrossOrigin("*")
public class AuthorityPersonController {
    @Autowired
    private AuthorityPersonService authorityPersonService;

//    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/")
    public ResponseEntity<AuthorityPersonDto> createAuthorityPerson(@Valid @RequestBody AuthorityPersonDto authorityPersonDto){
        AuthorityPersonDto authorityPerson = this.authorityPersonService.createAuthorityPerson(authorityPersonDto);
        return new ResponseEntity<>(authorityPerson, HttpStatus.CREATED);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponce>deleteAuthorityPerson(@PathVariable int id){
        this.authorityPersonService.deleteAuthorityPerson(id);
        return new ResponseEntity<>(new ApiResponce("AuthorityPerson deleted Successfully",true),HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<AuthorityPersonDto>updateAuthorityPerson(@Valid @RequestBody AuthorityPersonDto authorityPersonDto,@PathVariable int id){
        AuthorityPersonDto updateAuthorityPersonDto1 = this.authorityPersonService.updateAuthorityPerson(authorityPersonDto, id);
        return new ResponseEntity<>(updateAuthorityPersonDto1,HttpStatus.OK);
    }
    @GetMapping("/{email}")
    public ResponseEntity<AuthorityPersonDto>getSingleAuthorityPerson(@PathVariable String email){
        AuthorityPersonDto singleAuthorityPerson = this.authorityPersonService.getSingleAuthorityPerson(email);
        return new ResponseEntity<>(singleAuthorityPerson,HttpStatus.OK);
    }
}
