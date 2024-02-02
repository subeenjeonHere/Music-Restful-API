package com.sb.sampleapi.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
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
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @Column(name = "release_date")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @OneToMany(mappedBy = "album")
    private Collection<Music> music;
}
