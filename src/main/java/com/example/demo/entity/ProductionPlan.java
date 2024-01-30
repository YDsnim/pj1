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
    @Column
    private String ProductionCode;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "DATE",nullable = false)//columDefinition 을 이용하면 원하는 컬럼타입으로 데이터 추출가능
    private Date ProductionDate;//생산 예정일

    @Column(nullable = false)
    private Long ProductionQuantity; //생산 소요량

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "productName", referencedColumnName = "productName")
    private Product product;

    }

