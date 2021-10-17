package com.capgemini.nps.entity;
 
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

 
@Entity
@Table(name = "Accounts")
public class Account implements Serializable {
	

    private static final long serialVersionUID = -2054386655979281969L;
 
      
    public static final String ROLE_CLIENT = "CLIENT";
    //public static final String ROLE_EMPLOYEE = "EMPLOYEE";
 
    private String userName;
    private String password;
    private boolean active;
    private String userRole;
    
    /*@Transient
    private String captcha;*/
 
    @Id
    @Column(name = "User_Name", length = 20, nullable = false)
    public String getUserName() {
        return userName;
    }
 
    public void setUserName(String userName) {
        this.userName = userName;
    }
 
    @Column(name = "Password", length = 20, nullable = false)
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    @Column(name = "Active", length = 1, nullable = false)
    public boolean isActive() {
        return active;
    }
 
    public void setActive(boolean active) {
        this.active = active;
    }
 
    @Column(name = "User_Role", length = 20, nullable = false)
    public String getUserRole() {
        return userRole;
    }
 
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
    
    @Override
    public String toString()  {
        return "["+ this.userName+","+ this.password+","+ this.userRole+"]";
    }

	public Account() {
		
	}
	
	/*public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}*/
    
    
    
}