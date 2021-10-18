package com.capgemini.nps.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String getQuestionPage(HttpServletRequest request, HttpServletResponse response) {
		List<Question> questionList = questionService.fetchAllQuestions();
		//System.out.println(questionList);
		request.setAttribute("questionList", questionList);
        return "addquestion";
    }
	@GetMapping("/savequestionpage")
    public String getSaveQuestionPage() {
        return "savequestion";
    }
	
	@PostMapping("/savequestion")
	public String saveQuestion(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		String reqQuestion = request.getParameter("newquestion");
		String reqQuestionId = request.getParameter("questionid");
		if(null!=reqQuestion && !reqQuestion.isEmpty()) {
			Question question = new Question();
			question.setDescription(reqQuestion);
			if(null != reqQuestionId && !reqQuestionId.isEmpty()) {  //in case of edit scenario
				question.setId(Long.valueOf(reqQuestionId));
			}
			questionService.addQuestion(question);
			String teamId = session.getAttribute("teamId").toString();
			System.out.println("Team Id in savequestion====="+teamId);
			Survey survey = new Survey();
			survey.setTeamId(teamId);
			survey.setTopic(question.getDescription());
			surveyService.saveSurvey(survey);
			
		}
		List<Question> questionList = questionService.fetchAllQuestions();
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
}
