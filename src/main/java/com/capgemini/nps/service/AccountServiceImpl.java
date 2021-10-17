package com.capgemini.nps.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.nps.entity.Account;
import com.capgemini.nps.entity.RegisterTeam;
import com.capgemini.nps.repository.AccountRepository;
import com.capgemini.nps.repository.TRegisterRepository;

@Service
public class AccountServiceImpl implements AccountService {

	private final AccountRepository accountRepository;

	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
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
	public Account findAccount(String userName) {
		
		return accountRepository.findAllByUsername(userName);
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
