package com.example.demo.service;


import com.example.demo.dto.ProductionPlanDTO;
import com.example.demo.entity.ProductionPlan;
import com.example.demo.repository.ProductRepo;
import com.example.demo.repository.ProductionPlanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
//구현체
public class MainService implements MainServiceInter{
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ProductionPlanRepo productionPlanRepo;

    //DTO to ENTITY


//    @Override //이건 DTO를 불러서 엔티티각 컬럼과 바인딩하는 작업
//    public List<ProductionPlanDTO> ShowProductionPlanList() {
//        //
//        List<ProductionPlan> productionPlans = productionPlanRepo.findAll();
//        return null;
//    }

    @Override
    public void SaveProduction(ProductionPlanDTO productionPlanDTO) {
        ProductionPlan productionPlan = new ProductionPlan();


       productionPlan.setProductionQuantity(productionPlanDTO.getProductionQuantity());
        System.out.println("받은 제품수량 값: "+productionPlanDTO.getProductionQuantity());
        productionPlan.setProductionDate(productionPlanDTO.getProductionDate());
        System.out.println("받은 생산예정일 값: "+productionPlanDTO.getProductionDate());

        System.out.println("저장하고 싶은값"+productionPlan);
        //ProductRepo 를 통해서 DB에 저장
        productionPlanRepo.save(productionPlan);
    }




    @Override //리포짓토리에서 바로 구현 A1
    public List<ProductionPlan> ShowProductionPlanList() {


        return  productionPlanRepo.findAll();
    }

    @Override
    public void removePlan(Long ProductionPK) {
        productionPlanRepo.deleteById(ProductionPK);

    }
}
