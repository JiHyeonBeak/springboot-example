package com.pigsheep.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

/* DAO의 역할을 한다. JpaRepository<Entity클래스,PK>를 상속받는다.
   Entity 클래스와 함께 위치 해야 하므로 domain 패키지에서 함께 관리한다.
   해당 클래스를 상속받으면 CRUD가 자동 생성된다.
 */

@Repository
public interface PostsRepository extends JpaRepository<Posts,Long> {

    // 예시) JPA에서 제공하지 않는 쿼리는 직접 작성할 수 있다.
    // 가독성도 좋으므로, 필요시 선택해서 사용...
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
