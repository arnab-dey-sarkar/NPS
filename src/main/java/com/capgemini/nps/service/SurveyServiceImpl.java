package com.capgemini.nps.service;

import com.capgemini.nps.entity.Survey;
import com.capgemini.nps.exception.ResourceNotFoundException;
import com.capgemini.nps.repository.SurveyRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SurveyServiceImpl implements SurveyService {

	private final SurveyRepository surveyRepository;

	public SurveyServiceImpl(SurveyRepository surveyRepository) {
		this.surveyRepository = surveyRepository;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public Boolean isSurveyAlreadyExist(String topic) {
		return surveyRepository.existsByTopic(topic);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveSurvey(Survey survey) {
		/*
		 * if (survey.getNpmScore() != 0) { throw new
		 * RuntimeException("You can't set NPS!"); } else if
		 * (isSurveyAlreadyExist(survey.getTopic())) { throw new
		 * RuntimeException("This survey already exists!"); }
		 */
		int count = surveyRepository.answerExistsByTnameOrTopic(survey.getId(),survey.getTeamId());
		if (count == 0)
			surveyRepository.save(survey);
		else
			surveyRepository.updateAnswer(survey.getId(),survey.getTopic(),survey.getTeamId());
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Survey> getSurveys() {
		return surveyRepository.findAll();
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public ResponseEntity<Survey> getSurveyById(Long id) {
		Survey survey = surveyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Survey not exist with id: " + id));
		return ResponseEntity.ok(survey);
	}
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Survey> findAllQuestions(String tname) {
		return surveyRepository.findAllQuestions(tname);
	}
	
	
}
