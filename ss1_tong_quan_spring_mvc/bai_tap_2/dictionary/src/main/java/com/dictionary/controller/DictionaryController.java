package com.dictionary.controller;


import com.dictionary.service.DictionalServiceImpl;
import com.dictionary.service.IDictionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {

    @Autowired
    IDictionalService dictionalService;

    @GetMapping("/dictional")
    public String dictionary(){
        return "index";
    }

    @PostMapping("/dictional")
    public String result(@RequestParam String search, Model model){
        String result = dictionalService.searchDictional(search);
        model.addAttribute("result",result);
        return "index";

            }
        }


