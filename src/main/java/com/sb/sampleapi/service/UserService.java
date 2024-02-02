package com.sb.sampleapi.service;

import com.sb.sampleapi.domain.User;
import com.sb.sampleapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
    }

    public Optional<Object> findByUsername(String username) {
        userRepository.findByUsername(username);

    }
}
