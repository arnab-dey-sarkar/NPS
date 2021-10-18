package com.capgemini.nps.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.nps.entity.NPSScore;
import com.capgemini.nps.entity.Survey;
import com.capgemini.nps.service.AnswerService;

@Controller
@CrossOrigin(origins = "*")
public class NPSDashBoardController {

@Autowired
AnswerService answerService;

	 @RequestMapping(value = { "/npsScoreCalculate" }, method = RequestMethod.GET)
	 @Transactional(propagation = Propagation.NEVER)
	public String calculateNPS(Model model,@RequestParam(value = "teamId", defaultValue = "") String teamId,HttpServletRequest request, HttpSession session) {
		 System.out.println("Team Id in npsScore====="+teamId);
		 
		NPSScore calNPSScore = answerService.calNPSScore(teamId);
		model.addAttribute("npsScore",calNPSScore); 
		model.addAttribute("tname", teamId);
		return "npsdashboard";
	}
	 
	 @GetMapping("/calNpsScore")
	    public String getNPSPage(Model model) {
		   model.addAttribute("team",new Survey());
	        return "teamchooseforNPS";
	    }

	/*
	 * @GetMapping("/topic/{id}") public List<Answer>
	 * listAnswersByTopic(@PathVariable Long id) { return
	 * answerService.getAnswersByTopic(id); }
	 */

	/*
	 * @RequestMapping(value = { "/addAnswer" }, method = RequestMethod.POST)
	 * 
	 * @Transactional(propagation = Propagation.NEVER) public String
	 * saveAnswer(Model model,@ModelAttribute("answer") @Validated Answer answer, //
	 * BindingResult result, // final RedirectAttributes redirectAttributes) {
	 * 
	 * String message =""; try { Answer ans = answerService.saveAnswer(answer);
	 * 
	 * message ="Feedback noted successfully";
	 * 
	 * } catch(Exception e) { message ="Feedback registration failed"+e;
	 * 
	 * } model.addAttribute("message", message); return "feedback"; }
	 */
}
