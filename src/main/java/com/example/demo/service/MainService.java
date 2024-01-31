package com.example.demo.service;


import com.example.demo.dto.ProductionPlanDTO;
import com.example.demo.dto.ProductionPlanToEntityDTO;
import com.example.demo.dto.VendorDTO;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductionPlan;
import com.example.demo.entity.Vendor;
import com.example.demo.repository.ProductRepo;
import com.example.demo.repository.ProductionPlanRepo;
import com.example.demo.repository.VendorRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
//구현체
public class MainService implements MainServiceInter {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ProductionPlanRepo productionPlanRepo;
    @Autowired
    private VendorRepo vendorRepo;

    //DTO to ENTITY


    @Override   // 수정 버튼 누르면 해당 버튼의 열의 데이터를 읽음
    public void findRowDataByButton(VendorDTO vendorDTO) {
        VendorDTO rowData = new VendorDTO();
        rowData.setBusinessLicense(vendorDTO.getBusinessLicense());
        rowData.setVendorName(vendorDTO.getVendorName());
        rowData.setVendorAddress(vendorDTO.getVendorAddress());
        rowData.setVendorPnumber(vendorDTO.getVendorPnumber());
        rowData.setVendorEmail(vendorDTO.getVendorEmail());
        rowData.setPic(vendorDTO.getVendorEmail());
    }



    @Override
    public void SaveProduction(ProductionPlanToEntityDTO productionPlanToEntityDTO) {


//        productionPlan.setProductionCode(productionPlanDTO.getProductionPk());
//        System.out.println("받은 생산번호 값: " + productionPlanDTO.getProductionPk());
//
//        productionPlan.setProductionDate(productionPlanDTO.getProductionDate());
//        System.out.println("받은 생산예정일 값: " + productionPlanDTO.getProductionDate());
//
//        System.out.println("받은 제품 값: " + productionPlanDTO.getProductionQuantity());
//
//        productionPlan.setProductionQuantity(productionPlanDTO.getProductionQuantity());
//        System.out.println("받은 제품수량 값: " + productionPlanDTO.getProductionQuantity());

        //ProductRepo 를 통해서 DB에 저장
//        productionPlanRepo.save(productionPlan);
        productionPlanRepo.save(ProductionPlan.builder()
                .productionPk(productionPlanToEntityDTO.getProductionPk())
                .productionQuantity(productionPlanToEntityDTO.getProductionQuantity())
                .productionDate(productionPlanToEntityDTO.getProductionDate())
                .product( new Product(productionPlanToEntityDTO.getProduct().getProductCode(), productionPlanToEntityDTO.getProductionPk()))
                .complete(productionPlanToEntityDTO.getComplete())
                .build());

    }

    //거래처 등록/저장
    @Override
    public void RegisterVendor(VendorDTO vendorDTO) {
//        Vendor vendor = new Vendor();
//
//        vendor.setBusinessLicense(vendorDTO.getBusinessLicense());
//        System.out.println("입력받은 사업자 등록번호 값 :" + vendorDTO.getBusinessLicense());
//        vendor.setVendorName(vendorDTO.getVendorName());
//        System.out.println("입력받은 거래처 이름 값 :" + vendorDTO.getVendorName());
//        vendor.setVendorAddress(vendorDTO.getVendorAddress());
//        System.out.println("입력받은 거래처 주소 값 :" + vendorDTO.getVendorAddress());
//        vendor.setVendorPnumber(vendorDTO.getVendorPnumber());
//        System.out.println("입력받은 거래처 전화번호 값 :" + vendorDTO.getVendorPnumber());
//        vendor.setVendorEmail(vendorDTO.getVendorEmail());
//        System.out.println("입력받은 거래처 이메일 값 :" + vendorDTO.getVendorEmail());
//        vendor.setPic(vendorDTO.getPic());
//        System.out.println("입력받은 거래담당자 값 :" + vendorDTO.getPic());

        //VendorRepo 를 통해서 DB에 저장
        vendorRepo.save(Vendor.builder()
                        .businessLicense(vendorDTO.getBusinessLicense())
                        .vendorName(vendorDTO.getVendorName())
                        .vendorAddress(vendorDTO.getVendorAddress())
                        .vendorPnumber(vendorDTO.getVendorPnumber())
                        .vendorEmail(vendorDTO.getVendorEmail())
                        .vendorEmail(vendorDTO.getVendorEmail())
                        .PIC(vendorDTO.getPic())
                        .build());
    }

    @Override //리포짓토리에서 바로 구현 A1 DB에서 출력
    public List<ProductionPlan> ShowProductionPlanList() {
        return productionPlanRepo.findAll();
    }

    @Override//DB에서 출력
    public List<Vendor> ShowVendorList() {
        return vendorRepo.findAll();
    }
    @Override
    public List<Product> ProductList() {
        //제품 리스트 불러오는 메소드
        return productRepo.findAll();
    }


    //계획 삭제
    @Override
    public void removePlan(String productionPk) {
        productionPlanRepo.deleteById(productionPk);

    }

    //거래처 삭제
    @Override
    public void removeVendor(String businessLicense) {
        vendorRepo.deleteById(businessLicense);

    }





}
