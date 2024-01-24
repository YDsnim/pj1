package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name="production_plan")
@ToString

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductionPlan {
    @Id
    @Column(length = 20 ,nullable = false)
    private String ProductionPK; //PK

    @Column(nullable = false)
    private Long ProductionQuantity; //생산 소요량

    @Column(columnDefinition = "DATE",nullable = false)//columDefinition 을 이용하면 원하는 컬럼타입으로 데이터 추출가능
    private Date Production_date;//생산 예정일

    @Column(nullable=false)
    private Boolean complete;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product    product;


}
