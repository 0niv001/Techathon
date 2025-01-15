package com.example.springtest.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainPageController {
    @GetMapping("/mainpage")
    public String mainPage(Model model ) {
        return "mainpage";
    }

    @GetMapping("/article/investmentArticle")
    public String investmentArticle(Model model) {
        return "investmentArticle";

    }

    @GetMapping("/article/mortgagesArticle")
    public String mortgagesArticle(Model model) {
        return "mortgagesArticle";

    }
    @GetMapping("/article/pensionArticle")
    public String pensionArticle(Model model) {
        return "pensionArticle";

    }

    @GetMapping("/article/savingsArticle")
    public String savingsArticle(Model model) {
        return "savingsArticle";

    }

    @GetMapping("/article/mortgagesCalculator")
    public String mortgagesCalculator(Model model) {
        return "mortgagesCalculator";

    }
}
