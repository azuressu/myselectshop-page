package com.myselectshop.repository;

import com.myselectshop.entity.Folder;
import com.myselectshop.entity.Product;
import com.myselectshop.entity.ProductFolder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductFolderRepository extends JpaRepository<ProductFolder, Long> {
    Optional<ProductFolder> findByProductAndFolder(Product product, Folder folder);
    // Select * From product_folder Where product_id = ? and folder_id = ? ;
}
