package com.matheusfbio.spring_practice.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MessagerRepository {
    public String getMessage() {
        return "Hello from MessagerRepository!";
    }
}

