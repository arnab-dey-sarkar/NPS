package com.capgemini.nps.repository;

import com.capgemini.nps.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

	@Query(
	        value = "SELECT * FROM Answer c WHERE tname = :teamId ORDER BY tname ASC",
	        nativeQuery = true
	    )
	List<Answer> findAllByTeamId(@Param("teamId") String teamId);

	/* List<Answer> findAllBySurveyId(Long Id); */

}
