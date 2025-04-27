package com.example.ls.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicController {
    @GetMapping("/api/hello")
    public String hello() {
        return "Hello, public API!";
    }

    @GetMapping("/api/user")
    public String forUser() {
        return "Hello USER-role!";
    }

    @GetMapping("/api/admin")
    public String forAdmin() {
        return "Hello ADMIN-role!";
    }
}