package com.example.productapi.repository;

import com.example.productapi.model.ProductVariant;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductVariantRepository extends JpaRepository<ProductVariant, Long> {
    // find by product id
    List<ProductVariant> findByProductId(Long productId);
}
