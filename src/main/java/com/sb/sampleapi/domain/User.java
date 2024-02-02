package com.sb.sampleapi.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;


import java.util.Date;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "id")
    @Column(name = "user_id")
    private Long id;

    @Schema(description = "유저명")
    @Column(name = "username")
    private String username;

    @Schema(description = "비밀번호")
    @Column(name = "password")
    private String password;

    @Schema(description = "이메일")
    @Column(name = "email")
    private String email;

    @Schema(description = "생년월일")
    @Column(name = "date_birth")
    private Date birthdate;


}
