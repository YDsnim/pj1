package com.example.demo.service;

import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.ProductionPlanDTO;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductionPlan;

import java.util.List;

//여기엔 리포지토리 관련 작성 필요 x
public interface MainServiceInter {


    //DTO to ENTITY
    //즉 Service->Cont->VIEW->th-> DTO->ENTITY ->Repo->DB 저장

//   void SaveProduct(ProductDTO productDTO);


    //DTO to ENTITY
    void SaveProduction(ProductionPlanDTO productionPlanDTO); //입력값 저장
    //DB-> View

    List<ProductionPlan> ShowProductionPlanList();  //DB에서 출력

    //View->Controller->Service->Repo->DB
    void removePlan(Long RowNum);   //뷰에서 데이터 열 삭제


    /*
    1.Service 작성
        1-1 메서드 (ex)해당 DTO) 추가
        1-2 구현체에 상세 로직 작성
        1-3. 마지막 리턴에 리포짓토리.jpa명령어
    2.Controller 작성
        2-1 맵핑을 하거나 원하는 맵핑위치 찾기
        2-2 새로 작성시 타입 메소드 (모델 모델){
        (타입) ex) List<엔티티>  모델에 주입할 이름 = 서비스 구현체의 메소드
            model.addAttribute("th가 인식할 오브젝트",모델에 주입할 이름);
            return "원하는 리턴방식";
            }
    3.Repository 작성
            리포짓토리 특별한 쿼리가 있다면 작성(?)
     */



    }

