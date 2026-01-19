package com.matheusfbio.spring_practice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matheusfbio.spring_practice.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
