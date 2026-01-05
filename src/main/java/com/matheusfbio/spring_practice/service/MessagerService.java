package com.matheusfbio.spring_practice.service;

import org.springframework.stereotype.Service;
import com.matheusfbio.spring_practice.repository.MessagerRepository;

@Service
public class MessagerService {
    private final MessagerRepository messagerRepository;

    public MessagerService(MessagerRepository messagerRepository) {
        this.messagerRepository = messagerRepository;
    }

    public String fetchMessage() {
        return messagerRepository.getMessage();
    }
}
