package com.myselectshop.service;

import com.myselectshop.dto.ProductRequestDto;
import com.myselectshop.dto.ProductResponseDto;
import com.myselectshop.entity.Product;
import com.myselectshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponseDto createProduct(ProductRequestDto requestDto) {
        Product product = productRepository.save(new Product(requestDto));

        return new ProductResponseDto(product);
    }
}
