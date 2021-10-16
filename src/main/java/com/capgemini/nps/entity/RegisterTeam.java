package com.capgemini.nps.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class RegisterTeam  extends AbstractEntity{
	
	private String tname;
	private String tmanagername;
	private String tprojectid;
	private String tmembername;
	

}
