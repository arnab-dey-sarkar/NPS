package com.capgemini.nps.service;

import java.util.List;
import java.util.Optional;

import com.capgemini.nps.entity.Question;

public interface QuestionService {
	public void addQuestion(Question question);
	public List<Question> fetchAllQuestions(String teamId);
	public Optional<Question> fetchQuestionById(Long id);
	public void deleteQuestion(Long id);
}
