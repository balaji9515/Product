package com.product.productApplication.controller;

import com.product.productApplication.dto.ProductDto;
import com.product.productApplication.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@Tag(name = "Product Controller", description = "Product management APIs")
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

    public List<ProductDto> getAllProducts()
    {

        return productService.getAllProducts();
    }


}
