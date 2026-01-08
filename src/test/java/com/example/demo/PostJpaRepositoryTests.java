package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PostJpaRepositoryTests {

    @Autowired
    PostJpaRepository postJpaRepository;

    @Test
    @DisplayName("save가 호출되면 저장된 다음 id를 세팅해줄것이다.")
    void it_will_return_post_and_setting_id() throws Exception {

        // given
        final String TITLE = "title";
        final String CONTENT = "content";

        Post post = new Post(TITLE, CONTENT);

        // when
        Post saved = postJpaRepository.save(post);

        // then
        assertThat(saved.getId()).isEqualTo(1L);


    }



}