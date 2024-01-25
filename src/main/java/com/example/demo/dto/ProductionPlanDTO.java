package com.example.demo.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@NoArgsConstructor//인수가 없는 생성자를 생성합니다.
@AllArgsConstructor//모든 인수를 갖는 생성자를 생성합니다.
@Data

public class ProductionPlanDTO {

    private String ProductionPK; //PK

    private Long ProductionQuantity; //생산 소요량

    private Date ProductionDate;//생산 예정일

    private Boolean complete;
}
