package com.example.demo.service;


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
        productionPlanRepo.save(ProductionPlan.builder()
                .productionPk(productionPlanToEntityDTO.getProductionPk())
                .productionQuantity(productionPlanToEntityDTO.getProductionQuantity())
                .productionDate(productionPlanToEntityDTO.getProductionDate())
                .product(new Product(productionPlanToEntityDTO.getProduct().getProductCode(), productionPlanToEntityDTO.getProductionPk()))
                .complete(productionPlanToEntityDTO.getComplete())
                .build());

    }

    //거래처 등록/저장
    @Override
    public void RegisterVendor(VendorDTO vendorDTO) {

        //VendorRepo 를 통해서 DB에 저장
        vendorRepo.save(Vendor.builder()
                .businessLicense(vendorDTO.getBusinessLicense())
                .vendorName(vendorDTO.getVendorName())
                .vendorAddress(vendorDTO.getVendorAddress())
                .vendorPnumber(vendorDTO.getVendorPnumber())
                .vendorEmail(vendorDTO.getVendorEmail())
                .vendorEmail(vendorDTO.getVendorEmail())
                .pic(vendorDTO.getPic())
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
