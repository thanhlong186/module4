package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePage {
    @GetMapping(value = { "/", "/home"})
    public String home() {
        return "home";
    }
    @GetMapping("/meet")
    public String login() {
        return "loginForm";
    }
}
