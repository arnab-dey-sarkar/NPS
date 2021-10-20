package com.capgemini.nps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.nps.entity.Survey;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {

	Boolean existsByTopic(String topic);
	
	@Query(
	        value = "SELECT * FROM Survey c",
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
	
	
	@Modifying
	@Query(
	        value = "UPDATE Survey c SET c.topic= :topic WHERE c.team_id = :tName AND c.id= :tid",
	        nativeQuery = true
	    )
	int updateAnswer(@Param("tid")Long tid,@Param("topic")String topic,@Param("tName")String tName);
	@Query(
	        value = "SELECT COUNT(*) FROM Survey c WHERE c.team_id = :tName AND c.id= :tid",
	        nativeQuery = true
	    )
	int answerExistsByTnameOrTopic(@Param("tid")Long tid,@Param("tName")String tName);
	

}
