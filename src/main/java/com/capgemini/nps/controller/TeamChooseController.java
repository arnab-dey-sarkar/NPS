package com.capgemini.nps.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemini.nps.entity.Answer;
import com.capgemini.nps.entity.Survey;
import com.capgemini.nps.service.SurveyService;

@Controller
@CrossOrigin(origins = "*")
public class TeamChooseController {

	private final SurveyService surveyService;

	public TeamChooseController(SurveyService surveyService) {
		this.surveyService = surveyService;
	}

	 @RequestMapping(value = { "/getFeedback" }, method = RequestMethod.GET)
	 @Transactional(propagation = Propagation.NEVER)
	public String findAllQuestions(Model model,@RequestParam(value = "teamId", defaultValue = "") String teamId,HttpServletRequest request, HttpServletResponse response) {
		List<Survey> findAllQuestions = surveyService.findAllQuestions(teamId);
		model.addAttribute("questions",findAllQuestions);
		model.addAttribute("answer",new Answer());
		model.addAttribute("tname",teamId);
		HttpSession session = request.getSession();
		session.setAttribute("teamId", teamId);
		return "feedback";
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
