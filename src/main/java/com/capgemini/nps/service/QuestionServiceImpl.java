package com.capgemini.nps.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.nps.entity.Question;
import com.capgemini.nps.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	QuestionRepository questionRepo;

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

}
