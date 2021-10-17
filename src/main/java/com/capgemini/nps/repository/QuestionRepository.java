package com.capgemini.nps.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.nps.entity.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
	
}
