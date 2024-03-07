package com.pigsheep.book.springboot.domain.posts;

/*
모든 Entity의 상위 클래스로서, 생성일과 수정일을 자동관리하는 클래스가 된다.
 */

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass   // JPA의 모든 엔티티 클래스들이 해당 클래스를 상속할 경우, 클래스의 필드들도 컬럼으로 인식하게 한다.
@EntityListeners(AuditingEntityListener.class) // 해당 클래스에 Auditing기능을 포함시킨다.
public abstract class BaseTimeEntity {

    @CreatedDate    // 해당 엔티티가 생성되어 저장될때 시간이 자동 저장된다.
    private LocalDateTime createdDate;

    @LastModifiedDate   //조회한 엔티티의 값을 변경할때 시간이 자동 저장된다.
    private LocalDateTime modifiedDate;
}
