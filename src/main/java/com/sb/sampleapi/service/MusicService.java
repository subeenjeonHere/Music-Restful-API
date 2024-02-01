package com.sb.sampleapi.service;

import com.sb.sampleapi.domain.Music;
import com.sb.sampleapi.repository.MusicRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicService {

    private final MusicRepository musicRepository;

    public MusicService(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    public List<Music> getAllMusic() {
        return musicRepository.findAll();
    }

    public Music findBy(Integer id) {
        return musicRepository.findById(id);
    }

    public void save(Music music) {
        musicRepository.save(music);
    }

    public void deleteById(Integer id) {
        musicRepository.deleteById(id);
    }
}
