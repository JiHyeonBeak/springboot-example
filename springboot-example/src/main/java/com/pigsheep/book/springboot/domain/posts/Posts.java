package com.pigsheep.book.springboot.domain.posts;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor  // 롬복 어노테이션, 기본 생성자 자동 추가
@Entity // 실제 DB 테이블과 매칭될 클래스 선언. (테이블과 링크, 카멜케이스 클래스명을 DB의 언더스코어 네이밍으로 매칭)
public class Posts extends BaseTimeEntity{

    @Id // Posts 테이블의 PK 필드 선언
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 생성 규칙을 나타낸다.
    private Long id;

    @Column(length = 500, nullable = false) // 해당 테이블의 컬럼을 나타내고, 이 클래스의 필드는 모두 컬럼으로 인지한다. 설정값이 따로 있을때 사용.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder    // 해당 클래스의 빌더패턴 클래스 생성
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
