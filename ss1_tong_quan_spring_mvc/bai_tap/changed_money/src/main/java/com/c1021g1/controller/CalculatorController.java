package com.c1021g1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/")
    public String calculator() {
        return "index";
    }

    @GetMapping("/calculator")
    public String result(@RequestParam String rate, String usd, Model model) {
        float result = Float.parseFloat(rate) * Float.parseFloat(usd);
        model.addAttribute("ketqua", result);
        return "result";
    }
}