package com.example.ls.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello, Spring Security!";
    }
    @GetMapping("/secure")
    public String secure() {
        return "Bạn đã xác thực thành công!";
    }
}