package com.pigsheep.book.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        // 머스테치 스타터가 있어서, 앞 경로(resources/templates)와 뒤의 확장자(.mustache)는 자동 매핑된다.
        // View Resolver가 /src/main/resources/templates/index.mustache를 호출하게 된다.
        return "index";
    }
}
