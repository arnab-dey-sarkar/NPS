package com.capgemini.nps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NpsController {
    @GetMapping({"/","/home"})
    public String getIndexPage()
    {
        return "index";
    }
   
    @GetMapping("/registerPage")
    public String getRegisterPage() {

        return "register";
    }
    @GetMapping("/feedBack")
    public String getFeedBack() {

        return "feedback";
    }
}
