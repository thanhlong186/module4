package com.bai_tap.controller;

import com.bai_tap.model.Medical;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
public class MedicalController {
    @GetMapping
    public String displayForm(Model model) {
        model.addAttribute("medical", new Medical());
        model.addAttribute("vehicles", new String[]{"Tàu bay", "Tàu thuyền", "Ô tô", "Khác"});
        return "list";
    }

    @PostMapping("/home")
    public String Home(Medical medical, Model model) {
        String news = medical.toString();
        model.addAttribute("news", news);
        return "result";
    }
}
