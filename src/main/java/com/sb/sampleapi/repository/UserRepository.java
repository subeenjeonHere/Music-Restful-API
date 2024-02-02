package com.sb.sampleapi.repository;

import com.sb.sampleapi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Integer> {


    User findByUserNameOrEmail(String username, String username1);

    void findByUsername(String username);
}
