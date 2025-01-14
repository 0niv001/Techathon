package com.example.springtest.controllers;

import com.example.springtest.services.UserDataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SignUpController {

    @GetMapping("/signup")
    public String login() {
        return "signUp";
    }

    // Will let the user sign up or display error information
    @PostMapping("/signup")
    public String loginPost(@RequestParam String username, @RequestParam String password, @RequestParam String repeatPassword, Model model) {
        if (username.isEmpty()) {
            model.addAttribute("error", "Username cannot be empty");
            return "signUp";
        } else if (password.isEmpty()) {
            model.addAttribute("error", "Password cannot be empty");
            return "signUp";
        } else if (validUsername(username) && validPassword(password)) {

            // Add the user data to the array list of users
            List<String[]> users = UserDataService.getUserData();
            users.add(new String[]{username, password});

            // Take the user back to the login page
            return "login";
        } else if (!validUsername(username)) {
            model.addAttribute("error", "Username already exists. Try again.");
            return "signUp";
        } else if (!(password.equals(repeatPassword))) {
            model.addAttribute("error", "Passwords don't match");
            return "signUp";
        } else if (!validPassword(password)) {
            model.addAttribute("error", "Password must be at least 8 characters long and contain at least one number and one capital letter. Try again.");
            return "signUp";
        } else {
            model.addAttribute("error", "Invalid username or password. Try again.");
            return "signUp";
        }
    }

    private boolean validUsername(String username) {
        // Get the user credentials from the array list
        List<String[]> users = UserDataService.getUserData();

        // check if the username already exists in the array list
        boolean valid = false;
        for (String[] user : users) {
            if (!(user[0].equalsIgnoreCase(username))) {
                valid = true;
            } else {
                valid = false;
                break;
            }
        }
        return valid;
    }

    // Check if the password is valid
    private boolean validPassword(String password) {
        return password.length() >= 8 && // must be at least 8 characters long
                password.matches(".*\\d.*") && // must have at least one number
                password.matches(".*[A-Z].*"); // must have at least one capital letter
    }
}
