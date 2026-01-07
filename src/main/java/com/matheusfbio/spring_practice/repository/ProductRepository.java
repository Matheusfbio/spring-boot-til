package com.matheusfbio.spring_practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matheusfbio.spring_practice.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
