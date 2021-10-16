package com.capgemini.nps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.nps.entity.RegisterTeam;

@Repository
public interface TRegisterRepository extends JpaRepository<RegisterTeam, Long> {

	//List<Answer> findAllBySurveyId(Long Id);

}
