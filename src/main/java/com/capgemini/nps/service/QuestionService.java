package com.capgemini.nps.service;

import java.util.List;

import com.capgemini.nps.entity.Question;

public interface QuestionService {
	public void addQuestion(Question question);
	public List<Question> fetchAllQuestions();
}
