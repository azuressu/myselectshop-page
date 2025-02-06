package com.myselectshop.controller;

import com.myselectshop.dto.FolderRequestDto;
import com.myselectshop.dto.FolderResponseDto;
import com.myselectshop.security.UserDetailsImpl;
import com.myselectshop.service.FolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FolderController {

    private final FolderService folderService;

    /**
     * Folder를 추가하는 메서드
     * @param folderRequestDto : 생성할 folder명들을 받아옴
     * @param userDetails : 현재 로그인한 사용자의 정보
     */
    @PostMapping("/folders")
    public void addFolders(@RequestBody FolderRequestDto folderRequestDto,
                           @AuthenticationPrincipal UserDetailsImpl userDetails) {
        List<String> folderNames = folderRequestDto.getFolderNames();
        folderService.addFolders(folderNames, userDetails.getUser());
    }

    /**
     * 사용자의 Folders를 찾아 반환하는 메서드
     * @param userDetails : 현재 로그인한 사용자의 정보
     * @return : 로그인한 사용자의 folder들 반환
     */
    @GetMapping("/folders")
    public List<FolderResponseDto> getFolders(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return folderService.getFolders(userDetails.getUser());
    }

}
