package com.sb.sampleapi.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "likes")
@IdClass(LikeId.class)
public class Like {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "music_id", insertable = false, updatable = false)
    private Music music;

    @Column(name = "like_date")
    @Temporal(TemporalType.DATE)
    private Date likeDate;
}
