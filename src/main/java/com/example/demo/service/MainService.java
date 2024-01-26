package com.example.demo.service;


import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.ProductionPlanDTO;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductionPlan;
import com.example.demo.repository.ProductRepo;
import com.example.demo.repository.ProductionPlanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//구현체
public class MainService implements MainServiceInter{
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ProductionPlanRepo productionPlanRepo;
    //DTO to ENTITY
    @Override
    public void SaveProduct (ProductDTO productDTO) {
        Product product = new Product();
        product.setProductCode(productDTO.getProductCode());
        System.out.println("받은 제품코드 값: "+productDTO.getProductCode());
        product.setProductName(productDTO.getProductName());
        System.out.println("받은 제품명 값: "+productDTO.getProductName());

        //ProductRepo 를 통해서 DB에 저장
        productRepo.save(product);
    }

//    @Override //이건 DTO를 불러서 엔티티각 컬럼과 바인딩하는 작업
//    public List<ProductionPlanDTO> ShowProductionPlanList() {
//        //
//        List<ProductionPlan> productionPlans = productionPlanRepo.findAll();
//        return null;
//    }

    @Override //리포짓토리에서 바로 구현 A1
    public List<ProductionPlan> ShowProductionPlanList() {


        return  productionPlanRepo.findAll();
    }
}
