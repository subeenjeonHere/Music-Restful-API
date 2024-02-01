package com.sb.sampleapi.repository;


import com.sb.sampleapi.domain.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends JpaRepository<Music, Long> {

    Music findById(Integer id);

    void deleteById(Integer id);
}
