package com.example.demo.service;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;

public interface MainServiceInter {

    String ProductCode(ProductDTO dto); //제품의 코드

    //DTO to ENTITY
    default Product dtoToEntity(ProductDTO dto) {
        Product entity = Product.builder()
                .ProductCode(dto.getProductCode()) //제품의 코드
                .ProductName(dto.getProductName()) //제품의 이름
                .productionPlanList(dto.getProductionPlanList())
                .build();
        return entity;
    }
}
