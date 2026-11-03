package com.hcl.hclassessment2.Repository;

import com.hcl.hclassessment2.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> { java.util.List<Product> findByCategoryIgnoreCase(String category); java.util.List<Product> findByNameContainingIgnoreCase(String name); }
