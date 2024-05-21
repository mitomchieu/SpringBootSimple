package com.example.productapi.service;
import com.example.productapi.model.ProductVariant;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.productapi.repository.ProductVariantRepository;

@Service
public class ProductVariantService {
    @Autowired
    private ProductVariantRepository productVariantRepository;

    public List<ProductVariant> getProductVariants() {
        return productVariantRepository.findAll();
    }

    // get by product id
    public List<ProductVariant> getProductVariants(Long productId) {
        return productVariantRepository.findByProductId(productId);
    }
}
