package com.sb.sampleapi.domain;


import jakarta.persistence.*;

@Entity
@Table(name = "artists")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artist_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
}
