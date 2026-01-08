package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostJpaRepository postJpaRepository;

    @Transactional
    public Post save(PostSaveRequest request) {
        return postJpaRepository.save(new Post(request.title(), request.content()));
    }


}
