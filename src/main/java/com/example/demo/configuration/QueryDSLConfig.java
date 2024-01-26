package com.example.demo.configuration;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//프로젝트 어디에서나 사용할 수 있도록 QueryDSLConfig 클래스를 작성하여 Bean을 만드는 방법으로 선택했다.
//지속성 컨텍스트와 상호작용하는데 사용되는 EntityManager를 JPAQueryFactory 에 주입을 하여 jpaQueryFactory Bean을 생성한다.
//출처 https://medium.com/mo-zza/spring-data-jpa-querydsl-%EC%A0%81%EC%9A%A9-22a0364cd579
@Configuration
@RequiredArgsConstructor
public class QueryDSLConfig {
    private final EntityManager entityManager;

    @Bean
    public JPAQueryFactory jpaQueryFactory(){
        return new JPAQueryFactory(entityManager);
    }
}
