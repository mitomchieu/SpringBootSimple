package com.example.productapi.service;

import com.example.productapi.model.Product;
import com.example.productapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Cacheable(value = "products", key = "#name")
    public List<Product> searchProducts(String name) {
        System.out.println("searching for products with name: " + name);
        return productRepository.findByNameContaining(name);
    }

    // search by name and variantType1 and variantValue1
    @Cacheable(value = "products", key = "#name + '-' + #variantType1 + '-' + #variantValue1") 
    public List<Product> searchProducts(String name, String variantType1, String variantValue1) {
        return productRepository.findByNameAndVariantType1AndVariantValue1(name, variantType1, variantValue1);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
