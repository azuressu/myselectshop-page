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

    /**
     * Folder를 추가하는 메서드
     * @param folderNames : folder명이 담긴 List
     * @param user : folder를 추가하고자 하는 사용자
     */
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

    /**
     * 사용자의 Folders를 찾아 반환하는 메서드
     * @param user : folder를 찾고자 하는 사용자
     * @return : 찾은 folder list 반환
     */
    public List<FolderResponseDto> getFolders(User user) {
        List<Folder> folderList = folderRepository.findAllByUser(user);
        return folderList.stream().map(FolderResponseDto::new).toList();
    }

    /**
     * 폴더명이 존재하는지 확인하는 메서드
     * @param folderName : folder명
     * @param existFolderList : 사용자의 folder list (단, 새로 받아온 folder명들과 겹치는 경우)
     * @return : 폴더명 존재 여부를 return (true/false)
     */
    private boolean isExistFolderName(String folderName, List<Folder> existFolderList) {
        for (Folder folder : existFolderList) {
            if (folderName.equals(folder.getName())) {
                return true;
            }
        }
        return false;
    }
}
