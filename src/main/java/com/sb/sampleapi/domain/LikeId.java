package com.sb.sampleapi.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;

import java.io.Serializable;
import java.util.List;

public class LikeId implements Serializable {


//    @Column(name = "user_id")
    private Long userId;

//    @Column(name = "music_id")
    private Long musicId;


}
