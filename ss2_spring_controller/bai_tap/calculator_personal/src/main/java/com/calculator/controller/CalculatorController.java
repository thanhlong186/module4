package com.calculator.controller;

import com.calculator.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

        @Autowired
        CalculateService calculateService;

        @GetMapping("/")
        public String calculate() {

                return "index";
        }

        @PostMapping("/calculate")
        public String results(@RequestParam String number,
                             @RequestParam double no1,
                             @RequestParam double no2, Model model) {
                double ketQua = calculateService.calculation(number, no1, no2);
                model.addAttribute("result", ketQua);
                        return "index";
        }
}
