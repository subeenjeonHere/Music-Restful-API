package com.sb.sampleapi.service;

import com.sb.sampleapi.domain.Music;
import com.sb.sampleapi.repository.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MusicService {

    private final MusicRepository musicRepository;

    public List<Music> getAllMusic() {
        return musicRepository.findAll();
    }
}
