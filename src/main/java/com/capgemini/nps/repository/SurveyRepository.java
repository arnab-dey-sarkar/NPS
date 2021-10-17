package com.capgemini.nps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.nps.entity.Survey;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {

	Boolean existsByTopic(String topic);
	
	@Query(
	        value = "SELECT * FROM Survey c WHERE status is null",
	        nativeQuery = true
	    )
	public List<Survey> findAll();
	
	
	@Query(
	        value = "SELECT * FROM Survey c WHERE topic = :topic ORDER BY id ASC LIMIT 1",
	        nativeQuery = true
	    )
	public Survey findByTopic(@Param("topic") String topic );

	
	@Query(
	        value = "SELECT * FROM Survey c WHERE team_id = :tname ORDER BY team_id",
	        nativeQuery = true
	    )
	public List<Survey> findAllQuestions(@Param("tname") String tname);
	

}
