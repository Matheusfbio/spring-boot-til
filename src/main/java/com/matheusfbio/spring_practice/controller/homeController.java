package com.matheusfbio.spring_practice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class homeController {
    @GetMapping("/home")
    public String getMethodName() {
        return "Hello, This is the home endpoint.";
    }
}