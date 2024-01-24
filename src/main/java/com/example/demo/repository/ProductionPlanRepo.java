package com.example.demo.repository;

import com.example.demo.entity.ProductionPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductionPlanRepo extends JpaRepository<ProductionPlan,String> {


}
