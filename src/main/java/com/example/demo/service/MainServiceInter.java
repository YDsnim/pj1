package com.example.demo.service;

import com.example.demo.dto.ProductionPlanDTO;
import com.example.demo.dto.ProductionPlanToEntityDTO;
import com.example.demo.dto.VendorDTO;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductionPlan;
import com.example.demo.entity.Vendor;

import java.util.List;

//여기엔 리포지토리 관련 작성 필요 x
public interface MainServiceInter {

    //계약번호 조회기능

    public void findRowDataByButton (VendorDTO vendorDTO);
    //DTO to ENTITY
    // Service->Cont->VIEW->th-> DTO->ENTITY ->Repo->DB 저장
    void SaveProduction(ProductionPlanToEntityDTO productionPlanToEntityDTO); //계획등록 뷰에서 입력한 값 저장
    void RegisterVendor(VendorDTO vendorDTO); //거래처 등록 뷰에서 입력한 값 저장

    //DB-> View
        List<ProductionPlan> ShowProductionPlanList();  //DB에서 출력

        List<Vendor> ShowVendorList(); //DB에서 Vendor테이블 출력

    List<Product> ProductList();
    //View->Controller->Service->Repo->DB

    //계획 삭제
    void removePlan(String productionPk);//뷰에서 데이터 열 삭제

    void removeVendor(String businessLicense);   //뷰에서 데이터 열 삭제




    }

