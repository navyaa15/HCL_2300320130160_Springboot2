package com.hcl.hclassessment2.Entity;

import jakarta.persistence.*;
import java.util.*;

@Entity @Table(name="carts") public class Cart {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
@OneToOne(optional=false) @JoinColumn(name="customer_id",unique=true) private Customer customer;
@OneToMany(mappedBy="cart",cascade=CascadeType.ALL,orphanRemoval=true) private List<CartItem> items=new ArrayList<>();
public Long getId(){return id;} public void setId(Long x){id=x;}
public Customer getCustomer(){return customer;} public void setCustomer(Customer x){customer=x;}
public List<CartItem> getItems(){return items;}
}
