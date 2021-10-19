package com.capgemini.nps.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.nps.entity.Account;
import com.capgemini.nps.entity.Answer;
import com.capgemini.nps.entity.RegisterTeam;
import com.capgemini.nps.entity.Survey;
import com.capgemini.nps.service.AccountService;

@Controller
public class NpsController {
	
	@Autowired
	AccountService accountService;
	
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
    
    @GetMapping("/signout")
    public String logout(@RequestParam(name = "user") String user,HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        
       SecurityContextHolder.clearContext();
        session= request.getSession(false);
       if(session != null) {
           session.invalidate();
       }
       for(Cookie cookie : request.getCookies()) {
           cookie.setMaxAge(0);
       }
        return "login";  //Where you go after logout here.
    }
    
    @GetMapping("/signup")
    public String register() {
    	return "signup";
    }
    
    @PostMapping("/registeruser")
    public String registerUser(HttpServletRequest request, HttpServletResponse response) {
    	String userName = request.getParameter("username");
    	String password = request.getParameter("password");
    	Account account = new Account();
    	account.setUserName(userName);
    	account.setPassword(password);
    	account.setActive(true);
    	account.setUserRole(Account.ROLE_CLIENT);
    	accountService.registerUser(account);
    	request.setAttribute("account", account);
    	return "deletequestionconfirmation";
    }
}
