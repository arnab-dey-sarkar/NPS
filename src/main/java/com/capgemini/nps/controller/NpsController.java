package com.capgemini.nps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NpsController {
    @GetMapping("/")
    public String getIndexPage()
    {
        return "index";
    }
    @GetMapping("/home")
    public String getIndexPage1()
    {
        return "index";
    }
    @GetMapping("/registerPage")
    public String getRegisterPage() {

        return "register";
    }
}
