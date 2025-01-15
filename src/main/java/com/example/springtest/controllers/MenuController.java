package com.example.springtest.controllers;

import com.example.springtest.classes.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class MenuController {

    @GetMapping("/index")
    public String startPage(Model model) { return "index"; }
}
