package com.capgemini.nps.controller;

import com.capgemini.nps.entity.Answer;
import com.capgemini.nps.entity.RegisterTeam;
import com.capgemini.nps.entity.Survey;
import com.capgemini.nps.repository.SurveyRepository;
import com.capgemini.nps.service.AnswerService;
import com.capgemini.nps.service.SurveyService;
import com.capgemini.nps.service.SurveyServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@CrossOrigin(origins = "*")
public class AnswerController {

	private final AnswerService answerService;

	public AnswerController(AnswerService answerService) {
		this.answerService = answerService;
	}

	@Autowired
	SurveyRepository surveyRepository;

	@ResponseBody
	@RequestMapping(value = { "/answer" }, method = RequestMethod.GET)
	@Transactional(propagation = Propagation.NEVER)
	public List<Answer> findAllAnswers() {
		return answerService.getAnswers();
	}

	/*
	 * @GetMapping("/topic/{id}") public List<Answer>
	 * listAnswersByTopic(@PathVariable Long id) { return
	 * answerService.getAnswersByTopic(id); }
	 */

	@RequestMapping(value = { "/addAnswer" }, method = RequestMethod.POST)
	@Transactional(propagation = Propagation.NEVER)
	public String saveAnswer(Model model, @ModelAttribute("answer") @Validated Answer answer, //
			BindingResult result, //
			final RedirectAttributes redirectAttributes, HttpSession session, HttpServletRequest request) {

		String message = "";
		try {
			
			List<String> scores = new ArrayList<String>();
			Enumeration<String> enumeration = request.getParameterNames();
			while (enumeration.hasMoreElements()) {
			    String parameterName = (String) enumeration.nextElement();
			    if(parameterName.startsWith("Score")) {
			    	scores.add(request.getParameter(parameterName));
			    }
			}
			List<String> feedbacks = new ArrayList<String>();
			Enumeration<String> enumeration1 = request.getParameterNames();
			while (enumeration1.hasMoreElements()) {
			    String parameterName = (String) enumeration1.nextElement();
			    if(parameterName.startsWith("feedbackInput")) {
			    	feedbacks.add(request.getParameter(parameterName));
			    }
			}
			
			//for (Answer answer : answerList) {
			System.out.println(scores);
			System.out.println(feedbacks);
			List<String>topicList=Arrays.asList(answer.getTopic().split((",")));
			int i=0;
			for(String topic:topicList)
			{
				Answer answer1=new Answer();
				answer1.setTname(answer.getTname().split(",")[0]);
				answer1.setTopic(topic);
				answer1.setScore(Integer.parseInt(scores.get(i)));
				answer1.setFeedback(feedbacks.get(i));
				answer1.setId(answer.getId());
				answerService.saveAnswer(answer1);
				i++;
			}
			//}
				message = "Feedback noted successfully";
			
		} catch (Exception e) {
			message = "Feedback registration failed" + e;

		}
		model.addAttribute("message", message);

		String teamId = session.getAttribute("teamId").toString();
		System.out.println("Team Id=====" + teamId);

		List<Survey> findAllQuestions = surveyRepository.findAllQuestions(teamId);
		model.addAttribute("questions", findAllQuestions);

		return "feedback";
	}
}
