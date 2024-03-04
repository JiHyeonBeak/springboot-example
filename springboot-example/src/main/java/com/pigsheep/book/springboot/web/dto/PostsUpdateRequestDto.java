package com.pigsheep.book.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {

    private String tilte;
    private String content;

    @Builder
    public PostsUpdateRequestDto(String tilte, String content) {
        this.tilte = tilte;
        this.content = content;
    }
}