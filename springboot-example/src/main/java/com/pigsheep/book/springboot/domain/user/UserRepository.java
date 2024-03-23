package com.pigsheep.book.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users,Long> {

    //Optional<T> null일 수 있는 값을 감싸는 Wrapper클래스이다. 참조하더라도 null point Exception이 일어나지 않는다.
    Optional<Users> findByEmail(String email);

}
