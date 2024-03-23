package com.pigsheep.book.springboot.domain.user;

import com.pigsheep.book.springboot.domain.posts.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.pigsheep.book.springboot.domain.user.Role;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

@Getter
@NoArgsConstructor
@Entity
public class Users extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)    // db에 저장할때, enum값을 어떤 타입으로 저장할지 설정.
    @Column(nullable = false)
    private Role role;

    @Builder
    public Users(String name, String email, String picture, Role role) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    public Users update(String name, String picture) {
        this.name = name;
        this.picture = picture;
        return this;
    }

    public String getRolekey() {
        return this.role.getKey();
    }
}
