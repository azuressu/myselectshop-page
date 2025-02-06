package com.myselectshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    /**
     * 메인 페이지를 반환하는 메서드
     * @return : 메인 페이지 html명 반환
     */
    @GetMapping("/")
    public String home() {
        return "index";
    }
}
