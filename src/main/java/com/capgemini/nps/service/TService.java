package com.capgemini.nps.service;

import com.capgemini.nps.entity.RegisterTeam;
import com.capgemini.nps.entity.Survey;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface TService {

	//Boolean isSurveyAlreadyExist(String topic);

	RegisterTeam saveTeam(RegisterTeam rteam);
	
	List<RegisterTeam> getTeam();

	//List<Survey> getSurveys();

	//ResponseEntity<Survey> getSurveyById(Long topicId);
}
