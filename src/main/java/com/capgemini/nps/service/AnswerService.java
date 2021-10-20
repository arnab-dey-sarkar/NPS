package com.capgemini.nps.service;

import com.capgemini.nps.entity.Answer;
import com.capgemini.nps.entity.NPSScore;

import java.util.List;

public interface AnswerService {

	void saveAnswer(Answer answer);

	/* List<Answer> getAnswersByTopic(Long topicId); */

	List<Answer> getAnswers();

	NPSScore calNPSScore(String teamId);
	
}
