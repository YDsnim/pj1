package com.example.demo.controller;

import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.ProductionPlanDTO;
import com.example.demo.entity.ProductionPlan;
import com.example.demo.service.MainService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
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
        model.addAttribute("showProductionPlanList", productionPlanList);
        // ProductDTO를 뷰에서 사용하는 경우 아래와 같이 모델에 추가
        model.addAttribute("productionPlanDTO", new ProductionPlanDTO());

        //삭제시 뭘 지웠는지 로그로 표현
        log.info(  model.getAttribute("removePlan"));

        return "ProductionPlan";
    }


    @PostMapping("/saveProduct") //입력받은 제품키 , 제품명 저장
    public String saveProduction(@ModelAttribute ProductionPlanDTO productionPlanDTO) {
        log.info("저장버튼 클릭 확인");

        //타임리프에서 받아온 날짜정보 파싱하기
        Date dateStirng = productionPlanDTO.getProductionDate();
        Date productionDate = null;


        mainService.SaveProduction(productionPlanDTO);
        log.info("저장 완료 리다이렉트 합니다.");
        return "redirect:/ProductionPlan";
    }
//    @PostMapping("/saveProduct") //입력받은 제품키 , 제품명 저장
//    public String saveProduction(@ModelAttribute ProductionPlanDTO productionPlanDTO) {
//        mainService.SaveProduct(productionPlanDTO);
//        return "redirect:/ProductionPlan";
//    }


//
//    @GetMapping({"/exInline"})
//    public String exInline(RedirectAttributes redirectAttributes) {
//
//        log.info("ProductionPlan 진입");
//        log.info("exInline 배우기");
//
//        SampleDTO dto = SampleDTO.builder()
//                .ProductionPK("PK100")
//                .ProductionDate(Date.from(Instant.now()))
//                .ProductionQuantity(100L)
//                .complete(false)
//                .build();
//        redirectAttributes.addFlashAttribute("result", "success");
//        redirectAttributes.addFlashAttribute("dto", dto);
//
//        return "redirect:/ex3";
//    }
//
//    @GetMapping("/ex3")
//    public void ex3() {
//        log.info("ex3 진입");
//    }
//
//    @GetMapping({"exLink"})
//    public void exModel(Model model) {
//        List<SampleDTO> list = IntStream.rangeClosed(1, 20)
//                //asLongStream : ㅣIntStream의 int요소를 Long으로 변환해줌
//                .asLongStream()
//                .mapToObj(i -> {
//                    SampleDTO dto = SampleDTO.builder()
//                            .ProductionPK("PK100")
//                            .ProductionDate(Date.from(Instant.now()))
//                            .ProductionQuantity(100L)
//                            .complete(false)
//                            .build();
//                    return dto;
//                }).collect(Collectors.toList());
//        model.addAttribute("list", list);
//    }
//
//    //레이아웃 include방식 예제
////    th:replace  = 완전 대체 ; th:insert = 기존내용의 바깥쪽 태그는 그대로 유지하면서 추가되는 방식?
//    @GetMapping("/exLayout1")
//    public void exLayout1() {
//        log.info("exLayout1 진입");
//    }
//

    @PostMapping("/requestDelete")
    public String removePlan(@RequestParam Long RowNum , RedirectAttributes redirectAttributes){
        log.info("삭제 데이터 행 번호 : "+RowNum);
        mainService.removePlan(RowNum); //서비스 삭제기능 호출
        redirectAttributes.addFlashAttribute("removePlan","삭제한 행 번호"+RowNum);
        return "redirect:/ProductionPlan";
    }


}
