package com.capgemini.nps.repository;

import com.capgemini.nps.entity.Account;
import com.capgemini.nps.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

	@Query(
	        value = "SELECT * FROM Accounts c WHERE User_Name = :username ORDER BY User_Name ASC LIMIT 1",
	        nativeQuery = true
	    )
	    public Account findAllByUsername(@Param("username") String username );
	//Account findAllByUserName(String username);

}
