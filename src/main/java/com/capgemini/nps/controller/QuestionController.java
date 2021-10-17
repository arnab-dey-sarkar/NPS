package com.capgemini.nps.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.capgemini.nps.entity.Question;
import com.capgemini.nps.service.QuestionService;

@Controller
public class QuestionController {
	
	@Autowired
	QuestionService questionService;

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
	public String saveQuestion(HttpServletRequest request, HttpServletResponse response) {
		String reqQuestion = request.getParameter("newquestion");
		if(null!=reqQuestion && !reqQuestion.isEmpty()) {
			Question question = new Question();
			question.setDescription(reqQuestion);
			questionService.addQuestion(question);
		}
		List<Question> questionList = questionService.fetchAllQuestions();
		//System.out.println(questionList);
		request.setAttribute("questionList", questionList);
		return "addquestion";
	}
}
