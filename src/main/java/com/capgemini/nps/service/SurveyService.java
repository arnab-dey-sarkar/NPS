package com.capgemini.nps.service;

import com.capgemini.nps.entity.Survey;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface SurveyService {

	Boolean isSurveyAlreadyExist(String topic);

	void saveSurvey(Survey survey);

	List<Survey> getSurveys();

	ResponseEntity<Survey> getSurveyById(Long topicId);

	List<Survey> findAllQuestions(String tname);
}
