package com.hcl.hclassessment2.Repository;

import com.hcl.hclassessment2.Entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Long> { java.util.Optional<CartItem> findByCartIdAndProductId(Long cartId,Long productId); java.util.List<CartItem> findByCartId(Long cartId); boolean existsByProductId(Long productId); }
