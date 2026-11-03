package com.hcl.hclassessment2.Service;
import java.math.BigDecimal; import java.util.List;
public record CartResponse(Long cartId,Long customerId,List<Item> items,BigDecimal total) { public record Item(Long cartItemId,Long productId,String productName,int quantity,BigDecimal price,BigDecimal subtotal) {} }
