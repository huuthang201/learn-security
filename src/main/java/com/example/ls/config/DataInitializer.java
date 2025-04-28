package com.example.ls.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.ls.entity.Role;
import com.example.ls.entity.User;
import com.example.ls.repository.RoleRepository;
import com.example.ls.repository.UserRepository;

import java.util.Set;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner init(RoleRepository roleRepo,
                                  UserRepository userRepo,
                                  PasswordEncoder encoder) {
        return args -> {
            // Tạo roles
            var rUser = roleRepo.save(new Role(null, "ROLE_USER", null));
            var rAdmin = roleRepo.save(new Role(null, "ROLE_ADMIN", null));

            // Tạo users với roles tương ứng
            var user = new User();
            user.setUsername("user");
            user.setPassword(encoder.encode("user"));
            user.setRoles(Set.of(rUser));
            userRepo.save(user);

            var admin = new User();
            admin.setUsername("admin");
            admin.setPassword(encoder.encode("admin"));
            admin.setRoles(Set.of(rUser, rAdmin));
            userRepo.save(admin);
        };
    }
}