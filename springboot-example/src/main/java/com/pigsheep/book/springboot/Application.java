package com.pigsheep.book.springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 하기 어노테이션 부터 설정을 읽어가기에, 이 클래스는 프로젝트 최상단이 된다.
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // 내장 WAS 실행
        SpringApplication.run(Application.class, args);
    }
}
