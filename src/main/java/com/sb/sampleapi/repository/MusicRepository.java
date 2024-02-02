package com.sb.sampleapi.repository;


import com.sb.sampleapi.domain.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MusicRepository extends JpaRepository<Music, Integer> {

//    Optional<Music> findById(Integer id);

//    void deleteById(Integer id);
}
