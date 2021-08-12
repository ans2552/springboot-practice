package com.ans2552.practice.springboot.service.posts;

import com.ans2552.practice.springboot.domain.posts.Posts;
import com.ans2552.practice.springboot.domain.posts.PostsRepository;
import com.ans2552.practice.springboot.web.dto.PostsSaveRequestDto;
import com.ans2552.practice.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id" + id));

        posts.update(requestDto.getTitle(),requestDto.getContent());
        return id;
    }
}
