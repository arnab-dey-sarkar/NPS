package com.capgemini.nps.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.nps.entity.Question;
import com.capgemini.nps.entity.Survey;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
	
	
}
