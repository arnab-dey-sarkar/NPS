package com.capgemini.nps.service;

import com.capgemini.nps.entity.Answer;
import com.capgemini.nps.entity.NPSScore;
import com.capgemini.nps.entity.Survey;
import com.capgemini.nps.repository.AnswerRepository;
import com.capgemini.nps.repository.SurveyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Predicate;

@Service
public class AnswerServiceImpl implements AnswerService {

	private final AnswerRepository answerRepository;

	private final SurveyRepository surveyRepository;

	public AnswerServiceImpl(AnswerRepository answerRepository, SurveyRepository surveyRepository) {
		this.answerRepository = answerRepository;
		this.surveyRepository = surveyRepository;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveAnswer(Answer answer) {
		/*
		 * Survey survey = answer.getSurvey(); if (survey == null || survey.getId() ==
		 * null || survey.getId() == 0) { throw new
		 * RuntimeException("Answer has no assign by any Survey Topic!"); } else if
		 * (answer.getScore() < 0 || answer.getScore() > 10) { throw new
		 * RuntimeException("Score is invalid!"); }
		 * 
		 * survey = surveyRepository.getOne(survey.getId());
		 * 
		 * List<Answer> answers = answerRepository.findAllBySurveyId(survey.getId());
		 * answers.add(answer); int answerCount = answers.size(); if (answerCount != 0)
		 * { int promoterCount = 0; int detractorCount = 0; for (Answer anAnswer :
		 * answers) { if (anAnswer.getScore() >= 9) { promoterCount++; } else if
		 * (anAnswer.getScore() <= 6) { detractorCount++; } } int npmScore = (int) (100
		 * * ((float) (promoterCount - detractorCount) / answerCount));
		 * survey.setNpmScore(npmScore); surveyRepository.save(survey); }
		 */

		// Survey survey = surveyRepository.findByTopic(answer.getTopic());
		// survey.setStatus("Completed");
		// surveyRepository.save(survey);
		int count = answerRepository.answerExistsByTnameOrTopic(answer.getTname(), answer.getTopic());
		if (count == 0)
			answerRepository.save(answer);
		else
			answerRepository.updateAnswer(answer.getTname(), answer.getTopic(), answer.getFeedback(),
					answer.getScore());
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public NPSScore calNPSScore(String teamId) {
		/*
		 * Survey survey = answer.getSurvey(); if (survey == null || survey.getId() ==
		 * null || survey.getId() == 0) { throw new
		 * RuntimeException("Answer has no assign by any Survey Topic!"); } else if
		 * (answer.getScore() < 0 || answer.getScore() > 10) { throw new
		 * RuntimeException("Score is invalid!"); }
		 * 
		 * survey = surveyRepository.getOne(survey.getId());
		 * 
		 * List<Answer> answers = answerRepository.findAllBySurveyId(survey.getId());
		 * answers.add(answer); int answerCount = answers.size(); if (answerCount != 0)
		 * { int promoterCount = 0; int detractorCount = 0; for (Answer anAnswer :
		 * answers) { if (anAnswer.getScore() >= 9) { promoterCount++; } else if
		 * (anAnswer.getScore() <= 6) { detractorCount++; } } int npmScore = (int) (100
		 * * ((float) (promoterCount - detractorCount) / answerCount));
		 * survey.setNpmScore(npmScore); surveyRepository.save(survey); }
		 */

		List<Answer> answers = answerRepository.findAllByTeamId(teamId);
		int answerCount = answers.size();
		if (answerCount != 0) {
			int promoterCount = 0;
			int detractorCount = 0;
			int passiveCount = 0;
			for (Answer anAnswer : answers) {
				if (anAnswer.getScore() >= 9) {
					promoterCount++;
				}

				else if (anAnswer.getScore() <= 6) {
					detractorCount++;
				} else if (anAnswer.getScore() > 6 && anAnswer.getScore() < 9) {
					passiveCount++;
				}
			}
			int npmScore = (int) (100 * ((float) (promoterCount - detractorCount) / answerCount));
			NPSScore npsScore = new NPSScore();
			npsScore.setNps_score(npmScore);
			npsScore.setDetractor_count(detractorCount);
			npsScore.setPromoter_count(promoterCount);
			npsScore.setPassive_count(passiveCount);

			npsScore.setPromoter_pcnt((int) (100 * ((float) (promoterCount) / answerCount)));
			npsScore.setPassive_pcnt((int) (100 * ((float) (passiveCount) / answerCount)));
			npsScore.setDetractor_pcnt((int) (100 * ((float) (detractorCount) / answerCount)));
			return npsScore;
		}

		return null;
	}

	/*
	 * @Override
	 * 
	 * @Transactional(propagation = Propagation.SUPPORTS) public List<Answer>
	 * getAnswersByTopic(Long topicId) { return
	 * answerRepository.findAllBySurveyId(topicId); }
	 */

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Answer> getAnswers() {
		return answerRepository.findAll();
	}
}
