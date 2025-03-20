package com.product.productApplication.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.productApplication.dto.ProductDto;
import com.product.productApplication.model.Product;
import com.product.productApplication.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService
{

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ObjectMapper objectMapper;

    public ProductDto addProduct(ProductDto productDto)
    {
         Product pd= objectMapper.convertValue(productDto, Product.class);
         productRepository.save(pd);
         return productDto;
    }

    public List<ProductDto> getAllProducts()
    {
        return productRepository.findAll()
                .stream()
                .map(product -> objectMapper.convertValue(product, ProductDto.class))
                .collect(Collectors.toList());
    }

}
