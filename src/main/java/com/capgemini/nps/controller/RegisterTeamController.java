package com.capgemini.nps.controller;



import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.capgemini.nps.entity.RegisterTeam;
import com.capgemini.nps.service.TService;

@Controller
@CrossOrigin(origins = "*")
public class RegisterTeamController {

	private final TService tService;

	public RegisterTeamController(TService tService) {
		this.tService = tService;
	}

	@RequestMapping(value = { "/addTeam" }, method = RequestMethod.POST)
    @Transactional(propagation = Propagation.NEVER)
	public String saveTeam(Model model,@ModelAttribute("team") @Validated RegisterTeam registerTeam, //
            BindingResult result, //
            final RedirectAttributes redirectAttributes) {
		// TODO Convert Eklenecek
		String message ="";
		try {
		RegisterTeam saveTeam = tService.saveTeam(registerTeam);	
	
		message ="Team registered successfully";

		}
		catch(Exception e) {
		message ="Team registration failed"+e;	
			
		}
		model.addAttribute("message", message);
		return "register";
	}
	
	@ResponseBody
	 @RequestMapping(value = { "/getTeam" }, method = RequestMethod.GET)
	 @Transactional(propagation = Propagation.NEVER)
	    public List<RegisterTeam> getTeam(Model model) {
		 
		return tService.getTeam();
		 
	 }

	/*
	 * @GetMapping public List<Survey> findAllSurveys() { return
	 * surveyService.getSurveys(); }
	 */
}
