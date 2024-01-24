package com.example.demo.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
public class mainController {
    @GetMapping("/test1")
    void test1 (){

    log.info("test1 진입");

    }
}
