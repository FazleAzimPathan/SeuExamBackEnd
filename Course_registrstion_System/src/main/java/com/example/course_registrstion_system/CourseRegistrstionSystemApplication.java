package com.example.course_registrstion_system;

import com.example.course_registrstion_system.entity.Role;
import com.example.course_registrstion_system.payload.AppConstrain;
import com.example.course_registrstion_system.repo.RoleRpo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class CourseRegistrstionSystemApplication implements CommandLineRunner {
    @Autowired
    private RoleRpo roleRpo;

    public static void main(String[] args) {
        SpringApplication.run(CourseRegistrstionSystemApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Override
    public void run(String... args) throws Exception {
       Role role=new Role();
       role.setId(AppConstrain.ROLE_NORMAL);
       role.setName("ROLE_NORMAL");

       Role role1=new Role();
       role1.setId(AppConstrain.ROLE_ADMIN);
       role1.setName("ROLE_ADMIN");

        List<Role> roles = List.of(role, role1);
        this.roleRpo.saveAll(roles);

    }
}
