package com.example.course_registrstion_system.payload;

import com.example.course_registrstion_system.entity.Role;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
@Data
public class AuthorityPersonDto {
    private Integer id;
    @NotEmpty
    @Size(min = 4,message = "Name must be min of 4 characters")
    private String name;
    @Email(message = "Email address is not valid !!")
    private String email;
    @NotEmpty
    @Size(min =3,max=10,message = "Password must be in 3 to 10 character !!")
    private String password;
    Set<RoleDto> roles=new HashSet<>();
}
