package com.example.demo;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//엔티티 매니저를 JPAQueryFactory에 주입 = JPA 기능도도 같이 사용하게 만듬?
//쿼리DSL 에 JPA쿼리 팩토리를 빈으로 주입했기때문에  같이 쓸 수 있음
//이후 구현체에 아래의 JPA쿼리팩토리 bean을 주입받아서 사용하면 된다?
@Configuration //config파일이기 때문에 추가
public class QueryDSLConfig {
    @Autowired private EntityManager em;

    @Bean
    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(em);
    }
}
