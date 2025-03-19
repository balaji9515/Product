package com.product.controller;

import com.product.dto.ProductDto;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController
{
    @Autowired
    ProductService  productService;

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody ProductDto productDto)
    {
        productService.addProduct(productDto);
        return new ResponseEntity<>("Product Added", HttpStatusCode.valueOf(200));

    }

    @GetMapping("/all")

    public ResponseEntity<?> getAllProducts()
    {
        productService.getAllProducts();
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }


}
