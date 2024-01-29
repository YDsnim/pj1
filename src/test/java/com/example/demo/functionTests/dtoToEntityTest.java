package com.example.demo.functionTests;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Vendor;
import com.example.demo.repository.VendorRepo;
import com.example.demo.service.MainService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootTest
public class dtoToEntityTest {
    @Autowired
    private MainService mainService;

    @Autowired
    private VendorRepo vendorRepo;

    //
    @Test
    public void DTO() {
        ProductDTO productDTO = ProductDTO.builder()
                .ProductName("G999")

                .build();
        System.out.println(productDTO);
    }


    @Test
    void find() {
        String keyword = "123456789A";

        Optional<Vendor> result = vendorRepo.findById(keyword);

        List<Vendor> vList = result.stream()
                .collect(Collectors.toList());
        System.out.println(vList);

    };


}