package com.myselectshop.naver.controller;

import com.myselectshop.naver.dto.ItemDto;
import com.myselectshop.naver.service.NaverApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class NaverApiController {

    private final NaverApiService naverApiService;

    /**
     * Naver API를 활용한 아이템을 검색하는 메서드
     * @param query : 검색어
     * @return : 검색어에 해당하는 아이템들의 리스트 반환
     */
    @GetMapping("/search")
    public List<ItemDto> searchItems(@RequestParam String query)  {
        return naverApiService.searchItems(query);
    }
}
