package com.sb.sampleapi.domain;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.context.annotation.Configuration;

@Entity
@Data
@Table(name = "music")
@Schema(name = "음악 조회 응답 Entity")
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Schema(description = "id")
    private Long id;

    @NotBlank
    @Column(name = "title")
    @Schema(description = "타이틀")
    private String title;

    @NotBlank
    @Column(name = "artist")
    @Schema(description = "가수")
    private String artist;

    @NotBlank
    @Column(name = "album")
    @Schema(description = "앨범")
    private String album;
}
