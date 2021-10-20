package com.capgemini.nps.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.nps.entity.Answer;
import com.capgemini.nps.entity.Question;
import com.capgemini.nps.entity.Survey;
import com.capgemini.nps.service.QuestionService;
import com.capgemini.nps.service.SurveyService;

@Controller
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	@Autowired
	SurveyService surveyService;

	@GetMapping("/questionpage")
    public String getQuestionPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String teamId = session.getAttribute("teamId").toString();
		List<Question> questionList = questionService.fetchAllQuestions(teamId);
		//System.out.println(questionList);
		request.setAttribute("questionList", questionList);
        return "addquestion";
    }
	@GetMapping("/savequestionpage")
    public String getSaveQuestionPage() {
        return "savequestion";
    }
	
	@RequestMapping(value = { "/getTeamName" }, method = RequestMethod.GET)
	 @Transactional(propagation = Propagation.NEVER)
	public String getTeamName(Model model,@RequestParam(value = "teamId", defaultValue = "") String teamId,HttpServletRequest request, HttpServletResponse response) {
		/*
		 * List<Survey> findAllQuestions = surveyService.findAllQuestions(teamId);
		 * model.addAttribute("questions",findAllQuestions);
		 * model.addAttribute("answer",new Answer());
		 * model.addAttribute("tname",teamId);
		 */
		List<Question> questionList = questionService.fetchAllQuestions(teamId);
		//System.out.println(questionList);
		request.setAttribute("questionList", questionList);
		HttpSession session = request.getSession();
		session.setAttribute("teamId", teamId);
		return "addquestion";
	}
	
	@PostMapping("/savequestion")
	public String saveQuestion(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		String reqQuestion = request.getParameter("newquestion");
		String reqQuestionId = request.getParameter("questionid");
		String teamId = session.getAttribute("teamId").toString();
		if(null!=reqQuestion && !reqQuestion.isEmpty()) {
			Question question = new Question();
			question.setDescription(reqQuestion);
			if(null != reqQuestionId && !reqQuestionId.isEmpty()) {  //in case of edit scenario
				question.setId(Long.valueOf(reqQuestionId));
			}
			questionService.addQuestion(question);
			System.out.println("Team Id in savequestion====="+teamId);
			Survey survey = new Survey();
			survey.setTeamId(teamId);
			survey.setTopic(question.getDescription());
			survey.setId(question.getId());
			surveyService.saveSurvey(survey);
			
		}
		List<Question> questionList = questionService.fetchAllQuestions(teamId);
		//System.out.println(questionList);
		request.setAttribute("questionList", questionList);
		return "addquestion";
	}
	@GetMapping("/updatequestion/{id}")
	public String updateQuestion(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response) {
		Optional<Question> optionalquestion = questionService.fetchQuestionById(id);
		request.setAttribute("question", optionalquestion.get());
		return "savequestion";
	}

	@GetMapping("/deletequestion/{id}")
	public String deleteQuestion(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response) {
		questionService.deleteQuestion(id);
		/*List<Question> questionList = questionService.fetchAllQuestions();
		request.setAttribute("questionList", questionList);*/
        return "deletequestionconfirmation";
	}
	
	 @GetMapping("/teamChooseQues")
	    public String getNPSPage(Model model) {
		   model.addAttribute("team",new Survey());
	        return "teamchooseforQuestions";
	    }
}
