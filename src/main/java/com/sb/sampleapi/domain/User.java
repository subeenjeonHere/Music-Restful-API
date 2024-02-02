package com.sb.sampleapi.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


import java.util.Date;
import java.util.Set;

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
    @Column(name = "username", nullable = false)
    private String username;

    @Schema(description = "비밀번호")
    @Column(name = "password")
    private String password;

    @Schema(description = "이메일")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Schema(description = "생년월일")
    @Column(name = "date_birth")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
