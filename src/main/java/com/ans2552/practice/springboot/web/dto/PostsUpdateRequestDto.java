package com.ans2552.practice.springboot.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
    private String title;
    private String content;

    public PostsUpdateRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}