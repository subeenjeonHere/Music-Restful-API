package com.sb.sampleapi.domain;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;




@Entity
@Data
@Schema(name = "음악 조회 응답 Entity")
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "music_id")
    @Schema(description = "음악 ID")
    private Integer id;

    @Column(name = "title")
    @Schema(description = "음악 제목")
    private String title;

    @ManyToOne
    @JoinColumn(name = "album_id")
    @Schema(description = "앨범")
    private Album album;


    public Music() {
    }

    @Builder
    public Music(Integer id, String title) {
        this.id = id;
        this.title = title;
    }
}
