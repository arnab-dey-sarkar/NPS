package com.capgemini.nps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.capgemini.nps.entity.RegisterTeam;

@Controller
public class NpsController {
    @GetMapping({"/","/home"})
    public String getIndexPage()
    {
        return "index";
    }
   
    @GetMapping("/registerPage")
    public String getRegisterPage(Model model) {   
    	model.addAttribute("team",new RegisterTeam());
        return "register";
    }
    @GetMapping("/feedBack")
    public String getFeedBack() {

        return "feedback";
    }
}
