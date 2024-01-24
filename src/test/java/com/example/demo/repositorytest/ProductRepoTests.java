package com.example.demo.repositorytest;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepo;
import com.example.demo.repository.ProductionPlanRepo;
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
    public void testSelect() {
        String productCode = "PDC4"; //조회 할 검색어?
        Optional<Product> result = productRepo.findById(productCode); //findById 검색어 기준 찾는다. 프로덕트코드 Db
        System.out.println("=========================================");
        if (result.isPresent()) {
            Product product = result.get();
            System.out.println(product);
        }
    }


    @Test //내용 수정 테스트코드 <<<그냥 덮어쓰는 개념
        //작업할 엔티티를 불러서 builder() 열고 .각 항목("값") .bulid();
        //마지막 저장삭제조회수정 = 해당리포짓토리.save

    public void testUpdate(){
        Product product = Product.builder()
                .ProductCode("PDC0")
                .ProductName("G14")
                .build();
        productRepo.save(product);

    }

    @Test //내용 삭제
    //+삭제 처리 로그를 작성해 봄

    public void testDelete(){

        String productCode = "PDC3";//삭제 대상 입력
        productRepo.deleteById(productCode); //여기에 대입
        System.out.println(productCode+"삭제 요청"); //삭제 대상 확인 출력
        //삭제 후 엔티티 정보 가져오기 (조회)
        Optional<Product> beforeDel = productRepo.findById(productCode);

        //삭제 전 후에 엔티티 존재확인
        if(beforeDel.isPresent()){
            System.out.println("삭제 대상 확인" );
            System.out.println("삭제완료:"+productCode);
        }else {
            System.out.println("삭제하려는"+productCode+"가 존재하지않음" );
        }
    }


}
