package com.capgemini.nps.repository;

import com.capgemini.nps.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

	List<Answer> findAllBySurveyId(Long Id);

}
