package com.matheusfbio.spring_practice.service;

import java.util.List;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.matheusfbio.spring_practice.excepctions.ResourceNotFound;
import com.matheusfbio.spring_practice.model.Product;
import com.matheusfbio.spring_practice.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public Product getProductById(@NonNull Long id) {
        return productRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFound("The product with id "+id+" Não foi encontrado"));
    }

    public Product saveProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
            if (id == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }

        if (!productRepository.existsById(id)) {
            throw new ResourceNotFound("The product with id "+id+" Not Found");
        }
        productRepository.deleteById(id);
    }   
}
