package com.ans2552.practice.springboot.web;

import com.ans2552.practice.springboot.service.posts.PostsService;
import com.ans2552.practice.springboot.web.dto.PostsResponseDto;
import com.ans2552.practice.springboot.web.dto.PostsSaveRequestDto;
import com.ans2552.practice.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable long id) {
        return postsService.findById(id);
    }
}
