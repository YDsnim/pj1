package com.example.demo.repository;

import com.example.demo.dto.ProductionPlanDTO;

import java.util.List;
//여기서 생산계획 리포짓토리의 커스텀 쿼리는 여기에  선언 (서비스 인터페이스처럼)
//자세한 쿼리 동작은 구현체에서 작성

public interface ProductionPlanCustom {
    List<ProductionPlanDTO> findPlanByKeyword (Long ProductionPK);

}
