package com.example.springtest.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MainPageController {
    @GetMapping("/mainpage")
    public String mainPage(Model model ) {
        return "mainpage";
    }

}
