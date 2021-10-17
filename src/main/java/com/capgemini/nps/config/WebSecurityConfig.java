package com.capgemini.nps.config;
 


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.capgemini.nps.authentication.MyDBAuthenticationService;
 
@Configuration
// @EnableWebSecurity = @EnableWebMVCSecurity + Extra features
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
   @Autowired
   MyDBAuthenticationService myDBAauthenticationService;
 
   @Autowired
   public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
 
       // For User in database.
       auth.userDetailsService(myDBAauthenticationService);
 
   }
   
   @SuppressWarnings("deprecation")
@Bean
   public static NoOpPasswordEncoder passwordEncoder() {
       return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
   }
  
   
	  
	 
 
  @Override
   protected void configure(HttpSecurity http) throws Exception {
 
       http.csrf().disable();
       http.headers().frameOptions().disable();
       
       // The pages requires login as EMPLOYEE or MANAGER.
       // If no login, it will redirect to /login page.
		
		
		  http.authorizeRequests().antMatchers("/register","/feedback", "/addquestion")
		  .access("hasAnyRole('ROLE_CLIENT')");
		 
		  
		/*
		 * http.authorizeRequests().antMatchers("/register").access(
		 * "hasRole('ROLE_CLIENT')");
		 */
		 
 
       // When the user has logged in as XX.
       // But access a page that requires role YY,
       // AccessDeniedException will throw.
       http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
      // http.authorizeRequests().and().addFilterBefore(new ExUsernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
 
       // Config for Login Form
       http.authorizeRequests().and().formLogin()//
               // Submit URL of login page.
               .loginProcessingUrl("/j_spring_security_check") // Submit URL
               .loginPage("/login")//
               .defaultSuccessUrl("/registerPage")//
               .failureUrl("/login-error")//
               .usernameParameter("userName")//
               .passwordParameter("password")
               // Config for Logout Page
               // (Go to home page).
               .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login");
       
       
 
   }
   
   @Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myDBAauthenticationService).passwordEncoder(NoOpPasswordEncoder.getInstance());
	}
   
	
}