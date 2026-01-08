package com.example.demo;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostServiceTests {

    @Mock
    PostJpaRepository postJpaRepository;

    PostService postService;

    @BeforeEach
    void init() {
        postService = new PostService(postJpaRepository);
    }

    @Test
    void it_will_return_saved_post() throws Exception {

        // given
        final String TITLE = "title";
        final String CONTENT = "content";

        Post post = new Post(TITLE, CONTENT);

        PostSaveRequest saveRequest = new PostSaveRequest(TITLE, CONTENT);

        // when
        when(postJpaRepository.save(any(Post.class)))
                .thenReturn(post);

        Post saved = postService.save(saveRequest);

        // then
        assertThat(saved.getTitle()).isEqualTo(TITLE);
        assertThat(saved.getContent()).isEqualTo(CONTENT);

    }

}