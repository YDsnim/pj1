package com.example.demo.service;


import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//구현체
public class MainService implements MainServiceInter{
    @Autowired
    private ProductRepo productRepo;
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
}
