package com.myselectshop.naver.service;

import com.myselectshop.naver.dto.ItemDto;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Slf4j(topic = "NAVER API")
@Service
public class NaverApiService {

    private final RestTemplate restTemplate;

    @Value("${naver.client.id}")
    private String CLIENT_ID;

    @Value("${naver.client.secret}")
    private String CLIENT_SECRET;

    public NaverApiService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    /**
     * Naver API를 활용한 아이템을 검색하는 메서드
     * @param query : 검색어
     * @return : 검색어에 해당하는 아이템들의 리스트 반환
     */
    public List<ItemDto> searchItems(String query) {
        // 요청 URL 만들기
        URI uri = UriComponentsBuilder
                .fromUriString("https://openapi.naver.com")
                .path("/v1/search/shop.json")
                .queryParam("display", 15)
                .queryParam("query", query)
                .encode()
                .build()
                .toUri();
        log.info("uri = " + uri);

        RequestEntity<Void> requestEntity = RequestEntity
                .get(uri)
                .header("X-Naver-Client-Id", CLIENT_ID)
                .header("X-Naver-Client-Secret", CLIENT_SECRET)
                .build();

        ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);

        log.info("NAVER API Status Code : " + responseEntity.getStatusCode());

        return fromJSONtoItems(responseEntity.getBody());
    }

    /**
     * JSON 형대로 가져온 아이템의 내용을 ItemDto 객체로 변환
     * @param responseEntity : 응답에 담긴 아이템 내용들
     * @return : ItemDto로 담은 아이템들의 리스트 반환
     */
    public List<ItemDto> fromJSONtoItems(String responseEntity) {
        JSONObject jsonObject = new JSONObject(responseEntity);
        JSONArray items  = jsonObject.getJSONArray("items");
        List<ItemDto> itemDtoList = new ArrayList<>();

        for (Object item : items) {
            ItemDto itemDto = new ItemDto((JSONObject) item);
            itemDtoList.add(itemDto);
        }

        return itemDtoList;
    }
}
