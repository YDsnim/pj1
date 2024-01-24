package com.example.demo.repositorytest;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepo;
import com.example.demo.repository.ProductionPlanRepo;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;


@SpringBootTest
public class ProductRepoTests {
    @Autowired
    ProductionPlanRepo productionPlanRepo;
    @Autowired
    ProductRepo productRepo;

    //동적 프록시 생성 테스트 ok
    @Test
    public void testClass() {
        System.out.println(productionPlanRepo.getClass().getName());
    }

    @Test
    public void testClass2() {
        System.out.println(productRepo.getClass().getName());
    }


    @Test //JPA 활용 DB에 입력 테스트 코드 (리포짓토리.save)
    //null값 허용이 아닌경우 모드 빌드에 추가하도록
    public void testinsertDummies() {
        for (int i = 0; i <= 10; i++) {
            Product product = Product.builder()
                    .ProductCode("PDC" + i)
                    .ProductName("G" + i)
                    .build();
            productRepo.save(product);
            System.out.println(product.getProductCode());
            System.out.println(product.getProductName());

        }
    }


    @Test //조회기능 테스트
    public void testSelect(){
        String productCode = "PDC4";
        Optional<Product>result = productRepo.findById(productCode);
        System.out.println("=========================================");
        if(result.isPresent()){
            Product product = result.get();
            System.out.println(product);
        }
    }

}
