package com.hcl.hclassessment2.Repository;

import com.hcl.hclassessment2.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> { java.util.Optional<Cart> findByCustomerId(Long customerId); }
