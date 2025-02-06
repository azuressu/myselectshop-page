package com.myselectshop.controller;

import com.myselectshop.dto.ProductMypriceRequestDto;
import com.myselectshop.dto.ProductRequestDto;
import com.myselectshop.dto.ProductResponseDto;
import com.myselectshop.security.UserDetailsImpl;
import com.myselectshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    /**
     * 상품을 생성하는 메서드
     * @param requestDto : 추가할 상품의 정보
     * @param userDetails : 현재 로그인한 사용자
     * @return : 생성한 상품을 반환
     */
    @PostMapping("/products")
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return productService.createProduct(requestDto, userDetails.getUser());
    }

    /**
     * 상품의 최저가(사용자 정의)를 수정하는 메서드
     * @param id : 수정하려는 상품의 ID
     * @param requestDto : 수정하려는 최저가
     * @return : 수정한 상품을 반환
     */
    @PutMapping("/products/{id}")
    public ProductResponseDto updateProduct(@PathVariable Long id, @RequestBody ProductMypriceRequestDto requestDto) {
        return productService.updateProduct(id, requestDto);
    }

    /**
     * 등록한 전체 상품을 반환하는 메서드
     * @param page : 현재 페이지
     * @param size : 한 페이지에 보여줄 상품의 개수
     * @param sortBy : 정렬 기준 (ID, 상품명, 최저가)
     * @param isAsc : 오름차순/내림차순
     * @param userDetails : 현재 로그인한 사용자
     * @return : 해당 page에 존재하는 상품 반환
     */
    @GetMapping("/products")
    public Page<ProductResponseDto> getProducts(
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam("sortBy") String sortBy,
            @RequestParam("isAsc") boolean isAsc,
            @AuthenticationPrincipal UserDetailsImpl userDetails)
    {
        return productService.getProducts(userDetails.getUser(),
                page-1, size, sortBy, isAsc);
    }

    /**
     * 폴더를 추가하는 메서드
     * @param productId : 폴더에 추가할 상품의 ID
     * @param folderId : 추가할 폴더의 ID
     * @param userDetails : 현재 로그인한 사용자
     */
    @PostMapping("/products/{productId}/folder")
    public void addFolder(@PathVariable Long productId,
                          @RequestParam Long folderId,
                          @AuthenticationPrincipal UserDetailsImpl userDetails) {
        productService.addFolder(productId, folderId, userDetails.getUser());
    }

    /**
     * 해당 폴더에 담긴 상품만 조회하는 메서드
     * @param folderId : 가져올 폴더의 ID
     * @param page : 현재 페이지
     * @param size : 한 페이지에 보여줄 상품의 개수
     * @param sortBy : 정렬 기준 (ID, 상품명, 최저가)
     * @param isAsc : 오름차순/내림차순
     * @param userDetails : 현재 로그인한 사용자
     * @return : 해당 folder에 존재하는 상품 반환
     */
    @GetMapping("/folders/{folderId}/products")
    public Page<ProductResponseDto> getProductsInFolder(
            @PathVariable Long folderId,
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam("sortBy") String sortBy,
            @RequestParam("isAsc") boolean isAsc,
            @AuthenticationPrincipal UserDetailsImpl userDetails)
    {
        log.info("folderId: "+folderId.toString());
        return productService.getProductsInFolder(folderId, page-1, size, sortBy, isAsc, userDetails.getUser());
    }
}
