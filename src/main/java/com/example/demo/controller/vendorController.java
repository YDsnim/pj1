package com.example.demo.controller;

import com.example.demo.dto.ProductionPlanDTO;
import com.example.demo.dto.VendorDTO;
import com.example.demo.entity.ProductionPlan;
import com.example.demo.entity.Vendor;
import com.example.demo.repository.ProductionPlanCustom;
import com.example.demo.service.MainService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@Log4j2

public class vendorController {
    @Autowired
    private MainService mainService;
//    @Autowired
    //주입 할 빈 지정해준다
//    @Qualifier("productionPlanCustomImpl")
//    private ProductionPlanCustom productionPlanCustom;

    @GetMapping("/Vendor")
    public String ProductionPlan(Model model) {
        log.info("Vendor 진입");
        List<Vendor> vendorList = mainService.ShowVendorList();
        //DB의 등록된 거래처 목록을 출력
        model.addAttribute("showVendorList", vendorList);

//        //제품리스트를 읽어오는 모델
//        model.addAttribute("productList", mainService.ProductList());

//        // th에서 주입할 VendorDTO 바인딩 ( th->vendorDTO)
        model.addAttribute("vendorDTO", new VendorDTO());

        //삭제시 뭘 지웠는지 로그로 표현
        log.info(model.getAttribute("removeVendor"));
        return "/vendorRegister";
    }

    @PostMapping("/registerVendor") //입력받은 제품키 , 제품명 저장
    public String registerVendor(@ModelAttribute VendorDTO vendorDTO) {
        log.info("거래처 등록 버튼 클릭 확인");

        mainService.RegisterVendor(vendorDTO);
        log.info("저장 완료 리다이렉트 합니다.");
        return "redirect:/Vendor";
    }



    @PostMapping("/requestDeleteVendor")
    public String removeVendor(@RequestParam String businessLicense, RedirectAttributes redirectAttributes) {
        mainService.removeVendor(businessLicense); //서비스 삭제기능 호출
        redirectAttributes.addFlashAttribute("removeVendor", "삭제한 행 번호 :" + businessLicense);
        return "redirect:/Vendor";
    }






//
//    @GetMapping("/ProductionPlan/{productionPK}")
//    public ResponseEntity<List<ProductionPlanDTO>> getPlanByPK(@PathVariable Long productionPK) {
//       List<ProductionPlanDTO> planDTO = productionPlanCustom.findPlanByKeyword(productionPK);
//        return ResponseEntity.ok(planDTO); //완료시 planDTO 가져옴
//    }



}

