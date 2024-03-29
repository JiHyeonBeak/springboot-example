package com.pigsheep.book.springboot.service.posts;

import com.pigsheep.book.springboot.domain.posts.Posts;
import com.pigsheep.book.springboot.domain.posts.PostsRepository;
import com.pigsheep.book.springboot.web.dto.PostsListResponseDto;
import com.pigsheep.book.springboot.web.dto.PostsResponseDto;
import com.pigsheep.book.springboot.web.dto.PostsSaveRequestDto;
import com.pigsheep.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        /* 코드 가독성을 위하여 orElseThrow로 Exception 연결.
           IllegalArgumentException은 적합한 인자가 아닐시 예외를 반환한다.
         */
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        /*
            map(PostsListResponseDto::new)은 map(posts -> new PostsListResponseDto(posts))
            앞선 postsRepository.findAllDesc의 결과(posts)를 stream으로 넘겨 map형식으로 PostsListResponseDto를 반환한 다음,
            최종적으로 list로 변환한다.
         */
        return postsRepository.findAllDesc().stream().map(PostsListResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        postsRepository.delete(posts);
    }
}
