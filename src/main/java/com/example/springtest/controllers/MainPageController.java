package com.example.springtest.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
//controller to direct users to the blog page
@Controller
public class MainPageController {
    @GetMapping("/mainpage")
    public String mainpage(Model model ) {
        return "blog";
    }
    //

    //controller to directs users to the article page for investment
    @GetMapping("/article/investmentArticle")
    public String investmentArticle(Model model) {
        return "investmentArticle";

    }

    //directs users to mortgages article
    @GetMapping("/article/mortgagesArticle")
    public String mortgagesArticle(Model model) {
        return "mortgagesArticle";

    }

    //directs users to the pension article
    @GetMapping("/article/pensionArticle")
    public String pensionArticle(Model model) {
        return "pensionArticle";

    }

    //directs users to the savings article
    @GetMapping("/article/savingsArticle")
    public String savingsArticle(Model model) {
        return "savingsArticle";

    }

    //directs users to the mortgage calculator
    @GetMapping("/article/mortgagesCalculator")
    public String mortgagesCalculator(Model model) {
        return "mortgagesCalculator";

    }

    //directs users to the Course page
    @GetMapping("/course")
    public String course(Model model) {
        return "course";

    }
}
