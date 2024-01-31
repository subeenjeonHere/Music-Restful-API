package com.sb.sampleapi.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.sb.sampleapi.domain.Music;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.MockitoJUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import javax.management.StandardEmitterMBean;
import java.util.List;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MusicRepositoryTest {

    @Autowired
    private MusicRepository musicRepository;

    //목록전체조회
    @Test
    @DisplayName("Junit test for get all music")
    public void 음악목록조회() {
        //when
        List<Music> musicList = this.musicRepository.findAll();
        //then
        Assertions.assertThat(musicList).isNotEmpty();
    }

    //단건조회
    @Test
    @DisplayName("Junit test for get music by Id")
    public void 단건조회() {
        //when
        Music music = this.musicRepository.findById(1);
        //then
        Assertions.assertThat(music.getTitle());
    }

    //등록
    @Test
    @DisplayName("Junit tets for save music")
    public void 음악등록() {

        //given
        Music testmusic = new Music();
        testmusic.setId(99L);
        testmusic.setTitle("test Title");
        testmusic.setAlbum("test Album");
        testmusic.setArtist("test Artist");

        //when
        musicRepository.save(testmusic);

        //then
        Assertions.assertThat(testmusic.getId()).isGreaterThan(0);
    }

    //수정
    //삭제

}
