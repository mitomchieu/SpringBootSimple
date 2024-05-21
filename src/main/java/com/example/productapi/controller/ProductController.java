package com.example.productapi.controller;

import com.example.productapi.model.Product;
import com.example.productapi.model.ProductVariant;
import com.example.productapi.service.ProductService;
import com.example.productapi.service.ProductVariantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductVariantService productVariantService;

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        for (ProductVariant variant : product.getVariants()) {
            variant.setProduct(product);
        }
        return productService.saveProduct(product);
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String name) {
        return productService.searchProducts(name);
    }

    @GetMapping("/search/{name}/{variantType1}/{variantValue1}")
    public List<Product> searchProducts(@PathVariable String name, @PathVariable String variantType1, @PathVariable String variantValue1) {
        return productService.searchProducts(name, variantType1, variantValue1);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        if (productService.getProduct(id) == null) {
            return "Product not found";
        }
        productService.deleteProduct(id);
        return "Product deleted successfully";
    }

    // get variants of a product
    @GetMapping("/{id}/variants")
    public List<ProductVariant> getProductVariants(@PathVariable Long id) {
        return productVariantService.getProductVariants(id);
    }
}
