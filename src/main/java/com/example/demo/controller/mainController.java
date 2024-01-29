package com.example.demo.controller;

import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.ProductionPlanDTO;
import com.example.demo.entity.ProductionPlan;
import com.example.demo.repository.ProductionPlanCustom;
import com.example.demo.service.MainService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;

@Controller
@Log4j2

public class mainController {
    @Autowired
    private MainService mainService;
    @Autowired
    //주입 할 빈 지정해준다
    @Qualifier("productionPlanCustomImpl")
    private ProductionPlanCustom productionPlanCustom;

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
    public String removePlan(@RequestParam Long productionPK, RedirectAttributes redirectAttributes) {
//        log.info("삭제 데이터 행 번호 : "+rowNum);
        mainService.removePlan(productionPK); //서비스 삭제기능 호출
        redirectAttributes.addFlashAttribute("removePlan", "삭제한 행 번호 :" + productionPK);
        return "redirect:/ProductionPlan";
    }

    @GetMapping("/ProductionPlan/{productionPK}")
    public ResponseEntity<List<ProductionPlanDTO>> getPlanByPK(@PathVariable Long productionPK) {

       List<ProductionPlanDTO> planDTO = productionPlanCustom.findPlanByKeyword(productionPK);
        return ResponseEntity.ok(planDTO); //완료시 planDTO 가져옴
    }



}
