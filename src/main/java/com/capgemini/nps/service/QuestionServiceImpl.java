package com.capgemini.nps.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.nps.entity.Question;
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
	public List<Question> fetchAllQuestions() {
		List<Question> questionList = new ArrayList<>();
		questionRepo.findAll().forEach(question -> questionList.add(question));
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
