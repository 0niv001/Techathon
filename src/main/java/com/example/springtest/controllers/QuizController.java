package com.example.springtest.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class QuizController {

    // Directs the user to the first quiz page
    @GetMapping("/quiz/question1")
    public String question1() {
        return "quizQuestion1";
    }

    // Handles the first question
    @PostMapping("/quiz/question1")
    public String handleQuestion1(@RequestParam("answer") String answer, HttpSession session) {
        // initialise the score depending on the choice of answer
        int score = answer.equals("correctAnswer1") ? 1 : 0;
        // store the score in a user session
        session.setAttribute("score", score);
        // move to the next question
        return "redirect:/quiz/question2";
    }

    // Directs the user to the second quiz page
    @GetMapping("/quiz/question2")
    public String question2() {
        return "quizQuestion2";
    }

    // Handles the second question
    @PostMapping("/quiz/question2")
    public String handleQuestion2(@RequestParam("answer") String answer, HttpSession session) {
        // get the value of the score from the user session
        int score = (int) session.getAttribute("score");
        // update the score based on the user's choice
        score += answer.equals("correctAnswer2") ? 1 : 0;
        // store the updated score in the user session
        session.setAttribute("score", score);
        // move to the next question
        return "redirect:/quiz/question3";
    }

    // Directs the user to the third quiz page
    @GetMapping("/quiz/question3")
    public String question3() {
        return "quizQuestion3";
    }

    // Handles the third question and directs the user to the results page
    @PostMapping("/quiz/question3")
    public String handleQuestion3(@RequestParam("answer") String answer, HttpSession session, Model model) {
        // get the value of the score from the user session
        int score = (int) session.getAttribute("score");
        // update the score based on the user's choice
        score += answer.equals("correctAnswer3") ? 1 : 0;
        // store the updated score in the user session
        model.addAttribute("score", score);
        // move to the results page
        return "quizResults";
    }
}
