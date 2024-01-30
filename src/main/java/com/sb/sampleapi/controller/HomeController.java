package com.sb.sampleapi.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Main API", description = "Main")
@RestController
public class HomeController {

    @GetMapping("/")
    public String main() {
        return "메인 페이지 입니다.";
    }
}
