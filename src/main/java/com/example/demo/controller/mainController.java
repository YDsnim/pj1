package com.example.demo.controller;

import com.example.demo.dto.SampleDTO;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@Log4j2
public class mainController {
    @GetMapping({"/ProductionPlan"})
   void ProductionPlan() {

        log.info("ProductionPlan 진입");
        log.info("exInline 배우기");

        SampleDTO dto = SampleDTO.builder()
                .ProductionPK("PK100")
                .ProductionDate(Date.from(Instant.now()))
                .ProductionQuantity(100L)
                .complete(false)
                .build();

    }
    @GetMapping({"/exInline"})
    public String exInline(RedirectAttributes redirectAttributes) {

        log.info("ProductionPlan 진입");
        log.info("exInline 배우기");

        SampleDTO dto = SampleDTO.builder()
                .ProductionPK("PK100")
                .ProductionDate(Date.from(Instant.now()))
                .ProductionQuantity(100L)
                .complete(false)
                .build();
        redirectAttributes.addFlashAttribute("result", "success");
        redirectAttributes.addFlashAttribute("dto", dto);

        return "redirect:/ex3";
    }

    @GetMapping("/ex3")
    public void ex3() {
        log.info("ex3 진입");
    }

    @GetMapping({"/ProductionPlan","exLink"})
    public void exModel(Model model){
        List<SampleDTO> list = IntStream.rangeClosed(1,20)
                //asLongStream : ㅣIntStream의 int요소를 Long으로 변환해줌
                .asLongStream()
                .mapToObj(i->{
                    SampleDTO dto = SampleDTO.builder()
                            .ProductionPK("PK100")
                            .ProductionDate(Date.from(Instant.now()))
                            .ProductionQuantity(100L)
                            .complete(false)
                            .build();
                    return dto;
                }).collect(Collectors.toList());
        model.addAttribute("list",list);
    }
}
