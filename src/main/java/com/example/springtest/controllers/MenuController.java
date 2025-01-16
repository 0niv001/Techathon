package com.example.springtest.controllers;

import com.example.springtest.classes.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

    // Redirect to home
    @GetMapping("index")
    public String startPage(Model model) { return "index"; }

    // Redirect to blog
    @GetMapping("blog")
    public String blogPage(Model model) { return "blog"; }

    // Redirect to calculator
    @GetMapping("mortgagesCalculator")
    public String mortgagesCalculator(Model model) { return "mortgagesCalculator"; }

    // Redirect to course list
    @GetMapping("courseList")
    public String courseList(Model model) { return "courseList"; }

    // Determines which page the user should be provided with when the profile button is clicked
    @GetMapping("profileRedirect")
    public String profileRedirect(HttpSession session) {
        // Check if the user is logged in
        User user = (User) session.getAttribute("user");
        if (user != null) {
            return "redirect:/userpage";
        } else {
            return "redirect:/login";
        }
    }

}
