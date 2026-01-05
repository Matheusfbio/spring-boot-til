package com.matheusfbio.spring_practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheusfbio.spring_practice.service.MessagerService;
@RestController
@RequestMapping("/api")
public class MessagerController {
    private final MessagerService messagerService;

    public MessagerController(MessagerService messagerService) {
        this.messagerService = messagerService;
    }

    @GetMapping("/message")
    public String getMessage() {
        return messagerService.fetchMessage();
    }
}
