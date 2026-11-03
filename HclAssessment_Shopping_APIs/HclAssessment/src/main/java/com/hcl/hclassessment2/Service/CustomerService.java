package com.hcl.hclassessment2.Service;

import com.hcl.hclassessment2.Entity.*; import com.hcl.hclassessment2.Repository.*; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional; import org.springframework.http.HttpStatus; import org.springframework.web.server.ResponseStatusException; import java.util.*;

@Service public class CustomerService {
private final CustomerRepository customers; private final CartRepository carts;
public CustomerService(CustomerRepository customers,CartRepository carts){this.customers=customers;this.carts=carts;}
public Customer register(Customer c){if(customers.existsByEmailIgnoreCase(c.getEmail()))throw new ResponseStatusException(HttpStatus.CONFLICT,"Email already exists");c.setId(null);return customers.save(c);}
public List<Customer> all(){return customers.findAll();}
public Customer one(Long id){return customers.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer not found"));}
public Customer update(Long id,Customer data){Customer c=one(id);if(customers.existsByEmailIgnoreCaseAndIdNot(data.getEmail(),id))throw new ResponseStatusException(HttpStatus.CONFLICT,"Email already exists");c.setName(data.getName());c.setEmail(data.getEmail());c.setMobile(data.getMobile());return customers.save(c);}
@Transactional public void delete(Long id){Customer c=one(id);carts.findByCustomerId(id).ifPresent(carts::delete);customers.delete(c);}
}
