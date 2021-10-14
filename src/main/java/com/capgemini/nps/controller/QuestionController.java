package com.capgemini.nps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuestionController {

	@GetMapping("/questionpage")
    public String getRegisterPage() {

        return "addquestion";
    }
}
