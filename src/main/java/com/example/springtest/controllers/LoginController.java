package com.example.springtest.controllers;

import com.example.springtest.classes.User;
import com.example.springtest.services.UserDataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;

import java.util.List;

@Controller
public class LoginController {

    // Directs the user to the login page
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    // Will let the user log in or display error information
    @PostMapping("/login")
    public String loginPost(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
        if (username.isEmpty()) {
            model.addAttribute("error", "Username cannot be empty");
            return "login";
        } else if (password.isEmpty()) {
            model.addAttribute("error", "Password cannot be empty");
            return "login";
        } else if (checkCredentials(username, password)) {
            // Save the user's credentials in a user session
            User user = new User(username, password);
            session.setAttribute("user", user);

            // Take the user back to the home page
            return "redirect:/";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    private boolean checkCredentials(String username, String password) {
        // Get the user data from the array list
        List<String[]> users = UserDataService.getUserData();

        // Check if any usernames and passwords match
        for (String[] user : users) {
            if (user[0].equalsIgnoreCase(username) && user[1].equals(password)) {
                return true;
            }
        }
        return false;
    }
}
