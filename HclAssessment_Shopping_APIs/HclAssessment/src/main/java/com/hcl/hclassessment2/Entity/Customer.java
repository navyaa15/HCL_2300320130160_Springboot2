package com.hcl.hclassessment2.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity @Table(name="customers") public class Customer {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
@NotBlank private String name;
@NotBlank @Email @Column(nullable=false,unique=true) private String email;
@NotBlank @Pattern(regexp="\d{10}",message="Mobile must be 10 digits") private String mobile;
public Long getId(){return id;} public void setId(Long x){id=x;}
public String getName(){return name;} public void setName(String x){name=x;}
public String getEmail(){return email;} public void setEmail(String x){email=x;}
public String getMobile(){return mobile;} public void setMobile(String x){mobile=x;}
}
