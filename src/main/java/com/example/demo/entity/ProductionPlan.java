package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigInteger;
import java.util.Date;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductionPlan { //생산계획서

    @Id
    @Column(length = 20, nullable = false)
    private String productionPk; //

    @Column(nullable = false)
    private Long productionQuantity; // 생산소요량

    @Column(columnDefinition = "DATE", nullable = false)
    private Date productionDate; //생산예정일

    @Column(nullable = false)
    private Boolean complete;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;


}