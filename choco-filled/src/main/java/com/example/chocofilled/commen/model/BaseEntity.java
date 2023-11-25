package com.example.chocofilled.commen.model;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

/*
*  MappedSuperClass
*  부모 클래스는 테이블과 매핑하지 않고,
*  오로지 부모 클래스를 상속받는 자식 클래스에게 부모 클래스가 가지는
*  컬럼만 매핑정보로 제공하고 싶을 때 사용
* */
@Getter
@MappedSuperclass
@NoArgsConstructor
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp // JPA에서 엔티티의 생성 시간 처리
    @Column(name = "reg_date", updatable = false) // 생성 시간을 변경학지 않음
    private LocalDateTime regDate;

    public boolean isNew() {
        return this.id == null;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
