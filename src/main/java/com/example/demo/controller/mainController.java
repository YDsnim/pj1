package com.example.demo.controller;

import com.example.demo.dto.ProductionPlanDTO;
import com.example.demo.entity.ProductionPlan;
import com.example.demo.service.MainService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Log4j2

public class mainController {
    @Autowired
    private MainService mainService;

    @GetMapping("/ProductionPlan")
    public String ProductionPlan(Model model) {
        log.info("ProductionPlan 진입");
        List<ProductionPlan> productionPlanList = mainService.ShowProductionPlanList();
        //DB의 생상계획목록을 출력
        model.addAttribute("showProductionPlanList", productionPlanList);
        //제품리스트를 읽어오는 모델
        model.addAttribute("productList", mainService.ProductList());
        // 항목에 입력한 값을 th->ProductDTO로 전송 저장을 누르면
        model.addAttribute("productionPlanDTO", new ProductionPlanDTO());
        //삭제시 뭘 지웠는지 로그로 표현
        log.info(model.getAttribute("removePlan"));
        return "ProductionPlan";
    }

    @PostMapping("/saveProduct") //입력받은 제품키 , 제품명 저장
    public String saveProduction(@ModelAttribute ProductionPlanDTO productionPlanDTO) {
        log.info("저장버튼 클릭 확인");


        mainService.SaveProduction(productionPlanDTO);
        log.info("저장 완료 리다이렉트 합니다.");
        return "redirect:/ProductionPlan";
    }



    @PostMapping("/requestDelete")
    public String removePlan(@RequestParam String productionCode, RedirectAttributes redirectAttributes) {
        log.info("삭제버튼 누름");
        mainService.removePlan(productionCode); // 서비스 삭제기능 호출
        redirectAttributes.addFlashAttribute("removePlan", "삭제한 행 번호 :" + productionCode);
        return "redirect:/ProductionPlan";
    }




}
