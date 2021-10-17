package com.capgemini.nps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.capgemini.nps.entity.Answer;
import com.capgemini.nps.entity.RegisterTeam;
import com.capgemini.nps.entity.Survey;

@Controller
public class NpsController {
    @GetMapping({"/","/home"})
    public String getIndexPage()
    {
        return "login";
    }
   
    @GetMapping("/registerPage")
    public String getRegisterPage(Model model) {   
    	model.addAttribute("team",new RegisterTeam());
        return "register";
    }
    @GetMapping("/feedBack")
    public String getFeedBack(Model model) {
    	model.addAttribute("getfeedback",new Survey());
        return "teamchoose";
    }
    
	/*
	 * @GetMapping("/postteamchoose") public String postteamchoose() { return
	 * "feedback"; }
	 */
    
    @GetMapping("/login-error")
    public String login(Model model) {
        
        model.addAttribute("errorMessage", "Please enter valid credentials!!");
        return "login";
    }
}
