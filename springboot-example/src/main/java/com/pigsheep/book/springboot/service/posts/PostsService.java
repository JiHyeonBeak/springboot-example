package com.pigsheep.book.springboot.service.posts;

import com.pigsheep.book.springboot.domain.posts.Posts;
import com.pigsheep.book.springboot.domain.posts.PostsRepository;
import com.pigsheep.book.springboot.web.dto.PostsResponseDto;
import com.pigsheep.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    public PostsResponseDto findById(Long id) {

        /* 코드 가독성을 위하여 orElseThrow로 Exception 연결.
           IllegalArgumentException은 적합한 인자가 아닐시 예외를 반환한다.
         */
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        return new PostsResponseDto(entity);
    }
}
