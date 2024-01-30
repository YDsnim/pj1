package com.example.demo.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Builder
@NoArgsConstructor//인수가 없는 생성자를 생성합니다.
@AllArgsConstructor//모든 인수를 갖는 생성자를 생성합니다.
@Data

public class ProductionPlanDTO {
    private String productionPk;
    private Long productionQuantity;
    private Date productionDate;
    private ProductDTO product;
    //
    private String ProductName; //제품명


//    private String ProductionCode; //PK
//
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private Date ProductionDate;//생산 예정일
//
//
//    private Long ProductionQuantity; //생산 소요량



}
