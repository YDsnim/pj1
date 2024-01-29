package com.example.demo.repository;

import com.example.demo.dto.ProductionPlanDTO;
import com.example.demo.entity.ProductionPlan;
import com.example.demo.entity.QProductionPlan;
import com.querydsl.core.Tuple;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

//여기서 자세한 기능 작성 (구현체니까)
//쿼리 dsl 사용가능

@RequiredArgsConstructor  //해당 필드로 구성된 생성자를 @RequiredArgsConstructor가 자동으로 생성자 주입에 대한 코드를 생성.아니면 @Autowired 써야함
public class ProductionPlanCustomImpl implements ProductionPlanCustom {

    private final JPAQueryFactory jpaQueryFactory;


    @Override
    public List<ProductionPlanDTO> findPlanByKeyword(Long ProductionPK) {

        QProductionPlan pPlan = QProductionPlan.productionPlan;
        //QueryDsl 꺼로 임포트하자
        //JPAQuert<Tuple> <- 튜플형식으로 쿼리 결과를 받기
        JPAQuery<Tuple> tupleJPAQuery = jpaQueryFactory
                .select(
                        pPlan.ProductionPK,
                        pPlan.ProductionDate,
                        pPlan.product.productName,
                        pPlan.ProductionQuantity
                )
                .from(pPlan)
                .where(pPlan.ProductionPK.eq(ProductionPK))
                .orderBy(pPlan.ProductionPK.desc());

        return tupleJPAQuery.fetch().stream().map(tuple ->
                        ProductionPlanDTO.builder()
                                .ProductionPK(tuple.get(pPlan.ProductionPK))
                                .ProductionDate(tuple.get(pPlan.ProductionDate))
                                .ProductName(tuple.get(pPlan.product.productName))
                                .ProductionQuantity(tuple.get(pPlan.ProductionQuantity))
                                .build()
                ).toList();

    }
}
