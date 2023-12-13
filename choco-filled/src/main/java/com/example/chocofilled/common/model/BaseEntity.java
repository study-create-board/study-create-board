package com.example.chocofilled.common.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
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
public class BaseEntity { // TODO: 부모 클래스엔 BaseEntity 자체를 사용할 필요 없으니 추상클래스로 변경하는 것을 고려해보기

    // TODO: BaseEntity에 id를 두는게 맞을지 고려해보기
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp // JPA에서 엔티티의 생성 시간 처리
    @Column(name = "reg_date", updatable = false) // 생성 시간을 변경하지 않음 (보충 : 엔티티 변경 시에도 변경되지 않음)
    private LocalDateTime regDate;

    /** TODO: @UpdateTimestamp 사용하여 update시각 필드 만들기
     * TODO: Timestamp 어노테이션을 사용한다면 타입이 LocalDateTime vs Timestamp 둘 중 무엇이 더 나은지 고려하기
     * */

    // TODO: 이 필드를 어떻게 사용할 건지 생각해보고 사용 안할거라면 빼기
    public boolean isNew() {
        return this.id == null;
    }

    // TODO: 이 필드를 어떻게 사용할 건지 생각해보고 사용 안할거라면 빼기
    public void setId(Long id) {
        this.id = id;
    }
}