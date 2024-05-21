package com.example.productapi.repository;

import com.example.productapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContaining(String name);

    // find product contain name and variantType1 = smth, variantValue1 = smth
    @Query("SELECT p FROM Product p JOIN p.variants v WHERE p.name LIKE %:name% AND v.variantType1 = :variantType1 AND v.variantValue1 = :variantValue1")
    List<Product> findByNameAndVariantType1AndVariantValue1(@Param("name") String name, @Param("variantType1") String variantType1, @Param("variantValue1") String variantValue1);
}
