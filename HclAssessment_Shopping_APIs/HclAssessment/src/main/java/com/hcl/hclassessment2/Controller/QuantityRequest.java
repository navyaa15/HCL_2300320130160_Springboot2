package com.hcl.hclassessment2.Controller;
import jakarta.validation.constraints.*;
public record QuantityRequest(@NotNull @Min(1) Integer quantity) {}
