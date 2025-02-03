package com.myselectshop.repository;

import com.myselectshop.entity.Folder;
import com.myselectshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FolderRepository extends JpaRepository<Folder, Long> {
    List<Folder> findAllByUserAndNameIn(User user, List<String> folderNames);
    // Select * From Folder Where user_id = ? and name in (?, ?, ..);

    List<Folder> findAllByUser(User user);
}
