package com.example.demo.repository;

import com.example.demo.entity.ProductionPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface ProductionPlanRepo extends JpaRepository<ProductionPlan, Long> {


}
