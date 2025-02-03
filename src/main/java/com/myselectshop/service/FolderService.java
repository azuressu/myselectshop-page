package com.myselectshop.service;

import com.myselectshop.dto.FolderResponseDto;
import com.myselectshop.entity.Folder;
import com.myselectshop.entity.User;
import com.myselectshop.repository.FolderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FolderService {

    private final FolderRepository folderRepository;

    public void addFolders(List<String> folderNames, User user) {
        List<Folder> existFolderList = folderRepository.findAllByUserAndNameIn(user, folderNames);

        List<Folder> folderList = new ArrayList<>();

        for (String folderName : folderNames) {
            // 동일하지 않을 때 (동일한 폴더 이름이 존재하지 않는 경우 -> 생성 가능)
            if (!isExistFolderName(folderName, existFolderList)) {
                Folder folder = new Folder(folderName, user);
                folderList.add(folder);
            } else {
                throw new IllegalArgumentException("폴더명이 중복되었습니다.");
            }
        }

        folderRepository.saveAll(folderList);
    }

    public List<FolderResponseDto> getFolders(User user) {
        List<Folder> folderList = folderRepository.findAllByUser(user);
        return folderList.stream().map(FolderResponseDto::new).toList();
    }

    private boolean isExistFolderName(String folderName, List<Folder> existFolderList) {
        for (Folder folder : existFolderList) {
            if (folderName.equals(folder.getName())) {
                return true;
            }
        }
        return false;
    }
}
