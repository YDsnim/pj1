package com.example.demo.repository;

import com.example.demo.entity.ProductionPlan;
import org.springframework.data.jpa.repository.JpaRepository;


//JPA의 명령어가 아닌 것들은 여기에 기록해서 쓰겠다는 의미-> ProductionPlanCustom
public interface ProductionPlanRepo extends JpaRepository<ProductionPlan, String> {


}
