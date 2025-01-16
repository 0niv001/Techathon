package com.example.springtest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

    @GetMapping("index")
    public String startPage(Model model) { return "index"; }

    @GetMapping("blog")
    public String blogPage(Model model) { return "blog"; }

    @GetMapping("mortgagesCalculator")
    public String mortgagesCalculator(Model model) { return "mortgagesCalculator"; }

    @GetMapping("courseList")
    public String courseList(Model model) { return "courseList"; }

}
