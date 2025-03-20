package com.product.productApplication.controller;

import com.product.productApplication.dto.ProductDto;
import com.product.productApplication.model.Product;
import com.product.productApplication.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")

public class ProductController
{
    @Autowired
    ProductService  productService;

    @PostMapping("/create")
    public ProductDto createProduct(@RequestBody ProductDto productDto)
    {

        return productService.addProduct(productDto);


    }

    @GetMapping("/all")

    public List<ProductDto> getAllProducts()
    {

        return productService.getAllProducts();
    }


}
