package com.example.demo.repositorytest;

import com.example.demo.repository.ProductRepo;
import com.example.demo.repository.ProductionPlanRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductRepoTests {
    @Autowired
    ProductionPlanRepo productionPlanRepo;
    ProductRepo productRepo;

    @Test
    public void testClass(){
        System.out.println(productionPlanRepo.getClass().getName());
    }

    @Test
    public void testClass2(){
        System.out.println(productRepo.getClass().getName());
    }
}
