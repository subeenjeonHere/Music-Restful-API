package com.sb.sampleapi.controller;

import com.sb.sampleapi.domain.Music;
import com.sb.sampleapi.service.MusicService;
import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.status;

@RestController
@Slf4j
@Tag(name = "Music API", description = "음악 조회 CRUD API")
@RequestMapping("/api/music")
public class MusicController {

    private final MusicService musicService;

    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }

    /**
     * 음악 목록 조회 API
     * [GET] /api/music/
     *
     * @return musicList
     */
    @Operation(summary = "좋아하는 음악 목록 전체 조회", description = "등록된 모든 음악 목록을 조회합니다.")
    @GetMapping
    public ResponseEntity<List<Music>> getAllMusic() {
        List<Music> musicList = musicService.getAllMusic();

        return ResponseEntity.ok()
                .header(String.valueOf(200))
                .body(musicList);
    }

    /**
     * 음악 목록 단건 조회 API
     * [GET] /api/music/{id}
     *
     * @param id
     * @return music
     */
    @Operation(summary = "좋아하는 음악 단건 조회", description = "아이디(Id)를 통해 음악을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "음악 조회에 성공했습니다."),
            @ApiResponse(responseCode = "404", description = "음악을 찾을 수 없습니다.")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Music> getMusic(@Parameter(name = "id", description = "Music의 id", in = ParameterIn.PATH) @PathVariable("id") Integer id) {
        Music music = musicService.findBy(id);
        if (music == null) {
            return ResponseEntity.notFound()
                    .build();
        } else {
            return ResponseEntity.ok()
                    .header("200")
                    .body(music);
        }
    }

    /**
     * 음악 여러개 조회 API
     *
     */

    /**
     * 음악 등록 API
     * [POST] /api/music
     */
    @Operation(summary = "음악 등록", description = "좋아하는 음악을 등록합니다.")
    @PostMapping()
    public ResponseEntity<Music> createMusic(@RequestBody Music music) {
        try {
            musicService.save(music);
            return new ResponseEntity<>(music, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 음악 수정 API
     * [PUT] /api/music/{id}
     *
     * @param id
     * @return
     */
    @Operation(summary = "음악 수정", description = "좋아하는 음악 정보를 수정합니다.")
    @PutMapping("/{id}")
    public ResponseEntity<Music> updateMusic(@Parameter(name = "id", description = "수정할 Music의 id", in = ParameterIn.PATH) @PathVariable("id") Integer id, @RequestBody Music music) {
        try {
            Music updateMusic = musicService.findBy(id);
            if (updateMusic.getId().equals(id)) musicService.save(music);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 음악 삭제 API
     * [DELETE] /api/music/{id}
     *
     * @param id
     */
    @DeleteMapping
    public ResponseEntity<Music> deleteMusic(@Parameter(name = "id", description = "삭제할 Music의 id", in = ParameterIn.PATH) @PathVariable("id") Integer id) {
        musicService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}



