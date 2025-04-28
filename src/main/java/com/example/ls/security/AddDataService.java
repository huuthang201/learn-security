// package com.example.ls.security;

// import java.util.Collections;
// import java.util.HashSet;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;

// import com.example.ls.entity.Role;
// import com.example.ls.entity.User;
// import com.example.ls.repository.UserRepository;

// import jakarta.annotation.PostConstruct;

// @Service
// public class AddDataService {

//     @Autowired
//     private UserRepository userRepository;

//     @Autowired
//     private PasswordEncoder passwordEncoder;

//     @PostConstruct
//     public void init() {
//         // Tạo vai trò nếu chưa có
//         Role adminRole = new Role();
//         adminRole.setName("ROLE_ADMIN");

//         // Tạo người dùng admin
//         User admin = new User();
//         admin.setUsername("admin");
//         admin.setPassword(passwordEncoder.encode("password"));
//         admin.setEnabled(true);
//         admin.setRoles(new HashSet<>(Collections.singletonList(adminRole)));

//         // Lưu người dùng (tự động lưu liên kết vào users_roles)
//         userRepository.save(admin);
//     }
// }