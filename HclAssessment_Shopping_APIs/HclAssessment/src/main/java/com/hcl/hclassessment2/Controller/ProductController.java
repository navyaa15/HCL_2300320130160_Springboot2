package com.hcl.hclassessment2.Controller;

import com.hcl.hclassessment2.Entity.Product; import com.hcl.hclassessment2.Service.ProductService; import jakarta.validation.Valid; import org.springframework.web.bind.annotation.*; import org.springframework.http.HttpStatus; import java.util.List;

@RestController @RequestMapping("/api/products") public class ProductController {
private final ProductService service; public ProductController(ProductService service){this.service=service;}
@PostMapping @ResponseStatus(HttpStatus.CREATED) public Product add(@Valid @RequestBody Product p){return service.add(p);}
@GetMapping public List<Product> all(){return service.all();}
@GetMapping("/category/{category}") public List<Product> category(@PathVariable String category){return service.category(category);}
@GetMapping("/search") public List<Product> search(@RequestParam String name){return service.search(name);}
@GetMapping("/{id}") public Product one(@PathVariable Long id){return service.one(id);}
@PutMapping("/{id}") public Product update(@PathVariable Long id,@Valid @RequestBody Product p){return service.update(id,p);}
@DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){service.delete(id);}
}
