package com.hcl.hclassessment2.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

@Entity @Table(name="products") public class Product {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
@NotBlank private String name; @NotBlank private String category;
@NotNull @DecimalMin(value="0.0",inclusive=false) private BigDecimal price;
@NotNull @Min(0) private Integer quantity;
public Long getId(){return id;} public void setId(Long x){id=x;}
public String getName(){return name;} public void setName(String x){name=x;}
public String getCategory(){return category;} public void setCategory(String x){category=x;}
public BigDecimal getPrice(){return price;} public void setPrice(BigDecimal x){price=x;}
public Integer getQuantity(){return quantity;} public void setQuantity(Integer x){quantity=x;}
}
