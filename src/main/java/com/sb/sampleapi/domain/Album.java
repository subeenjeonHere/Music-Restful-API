package com.sb.sampleapi.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Entity
@Data
@Table(name = "albums")
@Schema(name = "앨범 조회 응답 Entity")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id")
    @Schema(description = "앨범 ID")
    private Integer id;

    private String name;

    private Date releaseDate;


}
