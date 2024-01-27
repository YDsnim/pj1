package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigInteger;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductionPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long RowNum; //PK

    @Column(nullable = false)
    private Long ProductionQuantity; //생산 소요량
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "DATE",nullable = false)//columDefinition 을 이용하면 원하는 컬럼타입으로 데이터 추출가능
    private Date ProductionDate;//생산 예정일


    }

