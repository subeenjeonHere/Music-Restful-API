package com.sb.sampleapi.repository;

import static org.awaitility.Awaitility.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sb.sampleapi.domain.Music;
import com.sb.sampleapi.domain.Music.MusicBuilder;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.management.StandardEmitterMBean;
import java.awt.*;
import java.util.List;
import java.util.Optional;


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
    @DisplayName("Junit test for save music")
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
    @Test
    @DisplayName("Junit test for update music")
    public void 음악수정_success() throws Exception {
        //given
        long id = 1L;
        Music savedMusic = musicRepository.findById(id).get();
        savedMusic.setTitle("new title");
        //when
        Music updatedMusic = musicRepository.save(savedMusic);
        //then
        Assertions.assertThat(updatedMusic.getTitle()).isEqualTo("new title");
    }

    //삭제
    @Test
    @DisplayName("Junit test for delete music")
    public void 음악삭제() throws Exception {

        //given
        long id = 999L;
        String title = "new Title";
        String artist = "new Artist";
        String album = "new Album";

        //when
        Music savedMUsic = Music.builder()
                .id(id)
                .title(title)
                .album(album)
                .artist(artist)
                .build();
        musicRepository.deleteById(savedMUsic.getId());

        //then
        musicRepository.findById(id);
        if (musicRepository.findById(id).isPresent()) {
            fail("Delete failed");
        }
    }
}
