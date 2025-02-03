package com.myselectshop.service;

import com.myselectshop.dto.ProductMypriceRequestDto;
import com.myselectshop.dto.ProductRequestDto;
import com.myselectshop.dto.ProductResponseDto;
import com.myselectshop.entity.Product;
import com.myselectshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public static final int MIN_MY_PRICE = 100;

    public ProductResponseDto createProduct(ProductRequestDto requestDto) {
        Product product = productRepository.save(new Product(requestDto));

        return new ProductResponseDto(product);
    }

    @Transactional
    public ProductResponseDto updateProduct(Long id, ProductMypriceRequestDto requestDto) {
        int myprice = requestDto.getMyprice();

        if (myprice < MIN_MY_PRICE) {
            throw new IllegalArgumentException("유효하지 않은 관심 가격입니다. 최소 " + MIN_MY_PRICE + "원 이상으로 설정해야 합니다.");
        }

        Product product = productRepository.findById(id).orElseThrow(() ->
                new NullPointerException("해당 상품을 찾을 수 없습니다")
        );

        product.update(requestDto);

        return new ProductResponseDto(product);
    }

    public List<ProductResponseDto> getProducts() {
        return productRepository.findAll().stream().map(ProductResponseDto::new).toList();
        /*
         List<Product> productList = productRepository.findAll();
         List<ProductResponseDto> productDtoList = new ArrayList<>();

         for (Product product: productList) {
            productDtoList.add(new ProductResposneDto(product));
         }

         return productDtoList;
         */
    }
}
