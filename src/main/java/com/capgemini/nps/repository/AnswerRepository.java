package com.capgemini.nps.repository;

import com.capgemini.nps.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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
	@Modifying
	@Query(
	        value = "UPDATE Answer c SET c.feedback= :feedback,c.score= :score WHERE c.tname = :tName AND c.topic= :topic",
	        nativeQuery = true
	    )
	int updateAnswer(@Param("tName")String tName,@Param("topic")String topic,@Param("feedback")String feedback,@Param("score")Integer score);
	@Query(
	        value = "SELECT COUNT(*) FROM Answer c WHERE c.tname = :tName AND c.topic= :topic",
	        nativeQuery = true
	    )
	int answerExistsByTnameOrTopic(@Param("tName")String tName,@Param("topic")String topic);

	/* List<Answer> findAllBySurveyId(Long Id); */

}
