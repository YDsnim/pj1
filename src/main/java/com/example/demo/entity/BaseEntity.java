package com.example.demo.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass //적용시 테이블을 생성하지 않음
@EntityListeners(value = {AuditingEntityListener.class}) //Auditing기능? 자동으로 값을 매핑?
@Getter
//abstract =추상적인
abstract class BaseEntity {
}
//Base엔티티는 자주 쓰이는 코드를  상속받은 엔티티들에게 사용하게 하는 편의성증가 엔티티  이건 나중에 쓰자