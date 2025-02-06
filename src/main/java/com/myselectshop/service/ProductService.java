package com.myselectshop.service;

import com.myselectshop.dto.ProductMypriceRequestDto;
import com.myselectshop.dto.ProductRequestDto;
import com.myselectshop.dto.ProductResponseDto;
import com.myselectshop.entity.*;
import com.myselectshop.naver.dto.ItemDto;
import com.myselectshop.repository.FolderRepository;
import com.myselectshop.repository.ProductFolderRepository;
import com.myselectshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final FolderRepository folderRepository;
    private final ProductFolderRepository productFolderRepository;

    public static final int MIN_MY_PRICE = 100;

    /**
     * 상품을 생성하는 메서드
     * @param requestDto : 추가할 상품의 정보
     * @param user : 현재 로그인한 사용자
     * @return : 새로 생성한 상품
     */
    public ProductResponseDto createProduct(ProductRequestDto requestDto, User user) {
        Product product = productRepository.save(new Product(requestDto, user));

        return new ProductResponseDto(product);
    }

    /**
     * 상품의 최저가(사용자 정의)를 수정하는 메서드
     * @param id : 수정할 상품의 ID
     * @param requestDto : 수정하려는 최저가
     * @return : 수정한 상품
     */
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

    /**
     * 등록한 전체 상품을 반환하는 메서드
     * @param user : 현재 로그인한 사용자
     * @param page : 현재 페이지
     * @param size : 한 페이지에 보여줄 상품의 개수
     * @param sortBy : 정렬 기준
     * @param isAsc : 오름차순/내림차순
     * @return : 해당 page에 존재하는 상품 반환
     */
    @Transactional(readOnly = true)
    public Page<ProductResponseDto> getProducts(User user, int page, int size, String sortBy, boolean isAsc) {
        Sort.Direction direction = isAsc ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, sortBy);

        Pageable pageable = PageRequest.of(page, size, sort);

        UserRoleEnum userRoleEnum = user.getRole();

        Page<Product> productList;

        if (userRoleEnum == UserRoleEnum.USER) {
            productList = productRepository.findAllByUser(user, pageable);
        } else {
            productList = productRepository.findAll(pageable);
        }

        return productList.map(ProductResponseDto::new);
    }

    /**
     * 검색을 통한 상품의 가격을 수정하는 메서드
     * @param id : 수정할 상품의 ID
     * @param itemDto : API 조회를 통해 가져온 상품의 정보
     */
    @Transactional
    public void updateBySearch(Long id, ItemDto itemDto) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NullPointerException("해당 상품은 존재하지 않습니다."));

        product.updateByItemDto(itemDto);
    }

    /**
     * 폴더를 추가하는 메서드
     * @param productId : 폴더에 추가할 상품의 ID
     * @param folderId : 추가할 폴더의 ID
     * @param user : 현재 로그인한 사용자
     */
    public void addFolder(Long productId, Long folderId, User user) {
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new NullPointerException("해당 상품이 존재하지 않습니다"));

        Folder folder = folderRepository.findById(folderId).orElseThrow(
                () -> new NullPointerException("해당 폴더가 존재하지 않습니다"));

        // 해당하는 유저가 아니라면
        if (!product.getUser().getId().equals(user.getId())
        ||  !folder.getUser().getId().equals(user.getId())) {
            throw new IllegalArgumentException("회원님의 관심상품이 아니거나, 회원님의 폴더가 아닙니다.");
        }

        // 중복 확인 필요 (이미 추가된 상품이 또 추가가 되지 않았는지)
        Optional<ProductFolder> overlapFolder = productFolderRepository.findByProductAndFolder(product, folder);

        if (overlapFolder.isPresent()) {
            throw new IllegalArgumentException("중복된 폴더입니다.");
        }

        productFolderRepository.save(new ProductFolder(product, folder));
    }

    /**
     * 해당 폴더에 담긴 상품만 조회하는 메서드
     * @param folderId : 가져올 폴더의 ID
     * @param page : 현재 페이지
     * @param size : 한 페이지에 보여줄 상품의 개수
     * @param sortBy : 정렬 기준 (ID, 상품명, 최저가)
     * @param isAsc : 오름차순/내림차순
     * @param user : 현재 로그인한 사용자
     * @return : 해당 folder에 존재하는 상품 반환
     */
    public Page<ProductResponseDto> getProductsInFolder(Long folderId, int page, int size, String sortBy, boolean isAsc, User user) {
        log.info("folderId: "+folderId);
        log.info("page: "+page);
        log.info("size: "+size);
        log.info("sortBy: "+sortBy);
        log.info("isAsc: "+isAsc);
        log.info("user: "+user.getUsername());

        Sort.Direction direction = isAsc ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, sortBy);

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Product> products = productRepository.findAllByUserAndProductFolderList_FolderId(user, folderId, pageable);
        return products.map(ProductResponseDto::new);
    }
}
