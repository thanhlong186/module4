package com.bai_tap.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SandwichController {

    @RequestMapping("/")
    public String save() {
        return "index";
    }

    @GetMapping("/save")
    public ModelAndView save(@RequestParam(value = "condiment", defaultValue = "a") String[] condiment, ModelAndView model) {
        ModelAndView modelAndView;
        if(!condiment[0].equals("a")){
            modelAndView = new ModelAndView("index", "result", condiment);
        } else {
           modelAndView = new ModelAndView("index", "result", "bạn phải chọn gia vị chứ.");
        }

        return modelAndView;

    }
}
