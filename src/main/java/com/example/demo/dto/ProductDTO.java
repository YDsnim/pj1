package com.example.demo.dto;

import com.example.demo.entity.ProductionPlan;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor//인수가 없는 생성자를 생성합니다.
@AllArgsConstructor//모든 인수를 갖는 생성자를 생성합니다.
@Data
public class ProductDTO {

    private String ProductCode; //제품의 코드
    private String ProductName; //제품의 이름
    private List<ProductionPlan> productionPlanList = new ArrayList<>();
}
