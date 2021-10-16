package com.capgemini.nps.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.nps.entity.RegisterTeam;
import com.capgemini.nps.repository.TRegisterRepository;

@Service
public class TServiceImpl implements TService {

	private final TRegisterRepository tRegisterRepository;

	public TServiceImpl(TRegisterRepository tRegisterRepository) {
		this.tRegisterRepository = tRegisterRepository;
	}

	/*
	 * @Override
	 * 
	 * @Transactional(propagation = Propagation.SUPPORTS) public Boolean
	 * isSurveyAlreadyExist(String topic) { return
	 * surveyRepository.existsByTopic(topic); }
	 */

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public RegisterTeam saveTeam(RegisterTeam registerTeam) {
		
		return tRegisterRepository.save(registerTeam);
	}

	/*
	 * @Override
	 * 
	 * @Transactional(propagation = Propagation.SUPPORTS) public List<Survey>
	 * getSurveys() { return surveyRepository.findAll(); }
	 * 
	 * @Override
	 * 
	 * @Transactional(propagation = Propagation.SUPPORTS) public
	 * ResponseEntity<Survey> getSurveyById(Long id) { Survey survey =
	 * surveyRepository.findById(id) .orElseThrow(() -> new
	 * ResourceNotFoundException("Survey not exist with id: " + id)); return
	 * ResponseEntity.ok(survey); }
	 */
}
