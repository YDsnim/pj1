package com.example.demo.service;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
//여기엔 리포지토리 관련 작성 필요 x
public interface MainServiceInter {


    //DTO to ENTITY
    //즉 Service->Cont->VIEW->th-> DTO->ENTITY ->Repo->DB 저장
   void SaveProduct(ProductDTO productDTO);

    }

