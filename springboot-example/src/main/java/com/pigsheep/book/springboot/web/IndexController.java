package com.pigsheep.book.springboot.web;

import com.pigsheep.book.springboot.service.posts.PostsService;
import com.pigsheep.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.h2.engine.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("posts",postsService.findAllDesc());
        // 머스테치 스타터가 있어서, 앞 경로(resources/templates)와 뒤의 확장자(.mustache)는 자동 매핑된다.
        // View Resolver가 /src/main/resources/templates/index.mustache를 호출하게 된다.
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);
        return "posts-update";
    }



}
