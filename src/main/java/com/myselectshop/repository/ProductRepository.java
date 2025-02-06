package com.myselectshop.repository;

import com.myselectshop.entity.Product;
import com.myselectshop.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAllByUser(User user, Pageable pageable);
    // Select * From product Where user_id = ? Limit ? Offset ?;

    Page<Product> findAllByUserAndProductFolderList_FolderId(User user, Long folderId, Pageable pageable);
    // Select * From product p
    //          Join product_folder pf On
    //          p.id = pf.product_id
    // Where p.user_id = ? AND pf.folder_id = ?
    // Limit ? Offset ?;

    /* Limit & Offset (AbstractpageRequest.java 참고)
     * Spring에서 자동으로 Pageable 객체를 통해 설정해주는 부분
     * Limit : 한 번에 가져올 데이터의 개수
     * Offset : 건너뛸 데이터의 개수 (페이지 수 = 데이터 개수 * 페이지 수)
     */
}
