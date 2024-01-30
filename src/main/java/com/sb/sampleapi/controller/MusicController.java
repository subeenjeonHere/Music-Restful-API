package com.sb.sampleapi.controller;

import com.sb.sampleapi.domain.Music;
import com.sb.sampleapi.service.MusicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/api/music")
//파일별로 API 분류하기
@Api(tags = "Music API", description = "Music CRUD API")
public class MusicController {
    
    private final MusicService musicService;

    //음악 목록 조회
    @ApiOperation(value = "좋아하는 음악 목록 조회", notes = "등록된 모든 음악 목록을 조회합니다.")
    @GetMapping
    public ResponseEntity<List<Music>> getAllMusic() {
        List<Music> musicList = musicService.getAllMusic();
        if (musicList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(musicList, HttpStatus.OK);
        }

    }

    //음악 등록
    //음악 단건 조회
    //음악 여러개 조회
    //음악 수정
    //음악 삭제
}
