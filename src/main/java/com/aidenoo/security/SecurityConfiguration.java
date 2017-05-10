package com.aidenoo.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.aidenoo.data.login.Login;
import com.aidenoo.data.login.LoginJDBC;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		
		LoginJDBC db = new LoginJDBC();
		List<Login> logins = db.readAll();
		
//		auth.inMemoryAuthentication().withUser("aidenoo").password("dummy")
//				.roles("USER", "ADMIN");
		
		for (Login login : logins) 
			auth.inMemoryAuthentication()
				.withUser(login.getLogin())
				.password(login.getPasswordx())
				.roles("USER");	
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/login").permitAll()
				.antMatchers("/", "/*todo*/**").access("hasRole('USER')").and()
				.formLogin();
	}
}