package com.example.demo.dto;

import com.example.demo.entity.ProductionPlan;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder(toBuilder = true)
//toBuilder: toBuilder() 메서드를 호출해서 기존객체의 빌더를 얻고 ,필요한 필드를 변경한 뒤에 ,.Build();를 사용하면 새로운 객체를 생성함
public class SampleDTO {

    private String ProductionPK;
    private Date ProductionDate;
    private Long ProductionQuantity; //생산 소요량
    private Boolean complete;

//    private List<ProductionPlan> productionPlanList = new ArrayList<>();

}
