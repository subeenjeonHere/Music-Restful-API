package com.sb.sampleapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String main() {
        return "메인 페이지 입니다.";
    }
}
