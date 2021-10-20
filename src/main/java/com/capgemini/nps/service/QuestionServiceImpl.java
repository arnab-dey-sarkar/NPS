package com.capgemini.nps.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.nps.entity.Question;
import com.capgemini.nps.entity.Survey;
import com.capgemini.nps.repository.QuestionRepository;
import com.capgemini.nps.repository.SurveyRepository;

@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	QuestionRepository questionRepo;
	@Autowired
	SurveyRepository surveyRepo;

	@Override
	public void addQuestion(Question question) {
		questionRepo.save(question);
	}

	@Override
	public List<Question> fetchAllQuestions(String teamId) {
		List<Question> questionList = new ArrayList<>();
		List<Survey> surveyList = surveyRepo.findAll();
		for(Survey survey: surveyList) {
			if(teamId.equalsIgnoreCase(survey.getTeamId())) {
				Question question = new Question();
				question.setId(survey.getId());
				question.setDescription(survey.getTopic());
				questionList.add(question);
			}
		}
		//questionRepo.findAll().forEach(question -> questionList.add(question));
		return questionList;
	}


	@Override
	public Optional<Question> fetchQuestionById(Long id) {
		return questionRepo.findById(id);
	}

	@Override
	public void deleteQuestion(Long id) {
		questionRepo.deleteById(id);
		surveyRepo.deleteById(id);
	}

}
