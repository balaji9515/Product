package com.product.productApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ProductDto
{
    private String name;
    private String description;
    private BigDecimal price;
}
