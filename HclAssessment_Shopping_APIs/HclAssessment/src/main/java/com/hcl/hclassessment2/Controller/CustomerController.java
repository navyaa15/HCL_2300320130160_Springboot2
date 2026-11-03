package com.hcl.hclassessment2.Controller;

import com.hcl.hclassessment2.Entity.Customer; import com.hcl.hclassessment2.Service.CustomerService; import jakarta.validation.Valid; import org.springframework.web.bind.annotation.*; import org.springframework.http.HttpStatus; import java.util.List;

@RestController @RequestMapping("/api/customers") public class CustomerController {
private final CustomerService service; public CustomerController(CustomerService service){this.service=service;}
@PostMapping("/register") @ResponseStatus(HttpStatus.CREATED) public Customer register(@Valid @RequestBody Customer c){return service.register(c);}
@GetMapping public List<Customer> all(){return service.all();}
@GetMapping("/{id}") public Customer one(@PathVariable Long id){return service.one(id);}
@PutMapping("/{id}") public Customer update(@PathVariable Long id,@Valid @RequestBody Customer c){return service.update(id,c);}
@DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){service.delete(id);}
}
