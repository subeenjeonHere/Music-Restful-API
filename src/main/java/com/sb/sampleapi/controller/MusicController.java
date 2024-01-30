package com.sb.sampleapi.controller;

import com.sb.sampleapi.domain.Music;
import com.sb.sampleapi.service.MusicService;
import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@Tag(name = "Music API", description = "음악 조회 CRUD API")
@RequestMapping("/api/music")
public class MusicController {

    private final MusicService musicService;

    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }

    //음악 단건 조회

    /**
     * 음악 목록 조회 API
     * [GET] /api/music/
     */
    @Operation(summary = "좋아하는 음악 목록 전체 조회", description = "등록된 모든 음악 목록을 조회합니다.")
    @GetMapping
    public ResponseEntity<List<Music>> getAllMusic() {
        List<Music> musicList = musicService.getAllMusic();

        return ResponseEntity.ok()
                .header(String.valueOf(200))
                .body(musicList);
    }

    @Operation(summary = "좋아하는 음악 단건 조회", description = "아이디(Id)를 통해 음악을 조회합니다.")
    @GetMapping("/{id}")
    public ResponseEntity<Music> getMusic(@Parameter(name = "id", description = "Music의 id", in = ParameterIn.PATH) @PathVariable("id") Integer id) {
        Music music = musicService.findBy(id);
        if (music == null) {
            return ResponseEntity.notFound()
                    .build();
        } else {
            return ResponseEntity.ok()
                    .header(String.valueOf(200))
                    .body(music);
        }
    }
    //음악 여러개 조회

    //음악 등록
    //음악 수정
    //음악 삭제


}


