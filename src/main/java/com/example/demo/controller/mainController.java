package com.example.demo.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
public class mainController {
    @GetMapping("/ProductionPlan")
    void ProductPlan (){

    log.info("Product 진입");

    }
}
