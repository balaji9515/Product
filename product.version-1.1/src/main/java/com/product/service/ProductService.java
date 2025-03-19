package com.product.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.dto.ProductDto;
import com.product.model.Product;
import com.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.DataInput;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService
{

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ObjectMapper objectMapper;

    public void addProduct(ProductDto productDto)
    {
         Product pd= objectMapper.convertValue(productDto, Product.class);
         productRepository.save(pd);
    }

    public List<ProductDto> getAllProducts()
    {
        return productRepository.findAll()
                .stream()
                .map(product -> objectMapper.convertValue(product, ProductDto.class))
                .collect(Collectors.toList());
    }

}
