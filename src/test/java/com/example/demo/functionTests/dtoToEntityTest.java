package com.example.demo.functionTests;

import com.example.demo.dto.ProductDTO;
import com.example.demo.service.MainService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class dtoToEntityTest {
    @Autowired
    private MainService mainService;

//
    @Test
    public void DTO(){
        ProductDTO productDTO = ProductDTO.builder()
                .ProductName("G999")

                .build();
                System.out.println(productDTO);
        }
    }

