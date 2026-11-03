package com.hcl.hclassessment2.Service;

import com.hcl.hclassessment2.Entity.*; import com.hcl.hclassessment2.Repository.*; import org.springframework.stereotype.Service; import org.springframework.http.HttpStatus; import org.springframework.web.server.ResponseStatusException; import java.util.*;

@Service public class ProductService {
private final ProductRepository products; private final CartItemRepository items;
public ProductService(ProductRepository products,CartItemRepository items){this.products=products;this.items=items;}
public Product add(Product p){p.setId(null);return products.save(p);}
public List<Product> all(){return products.findAll();}
public Product one(Long id){return products.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Product not found"));}
public Product update(Long id,Product data){Product p=one(id);p.setName(data.getName());p.setCategory(data.getCategory());p.setPrice(data.getPrice());p.setQuantity(data.getQuantity());return products.save(p);}
public void delete(Long id){Product p=one(id);if(items.existsByProductId(id))throw new ResponseStatusException(HttpStatus.CONFLICT,"Product exists in a cart");products.delete(p);}
public List<Product> category(String value){return products.findByCategoryIgnoreCase(value);}
public List<Product> search(String value){return products.findByNameContainingIgnoreCase(value);}
}
