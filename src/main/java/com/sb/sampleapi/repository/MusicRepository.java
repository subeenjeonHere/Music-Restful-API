package com.sb.sampleapi.repository;


import com.sb.sampleapi.domain.Music;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MusicRepository extends JpaRepository<Music, Integer> {

    Optional<Music> findById(Integer id);

    void deleteById(Integer id);
}
