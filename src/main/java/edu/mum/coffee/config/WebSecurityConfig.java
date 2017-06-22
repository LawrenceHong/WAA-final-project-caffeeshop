package edu.mum.coffee.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	CustomSuccessHandler customSuccessHandler;
	@Autowired
	DataSource dataSource;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/user/**").access("hasRole('USER')").antMatchers("/admin/**")
				.access("hasRole('ADMIN')").antMatchers("/", "/home", "/index").permitAll().anyRequest().authenticated()
				.and().formLogin().permitAll().successHandler(customSuccessHandler).and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/").permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("super").password("123").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("user@gmail.com").password("123").roles("USER");
		auth.jdbcAuthentication().dataSource(dataSource)
	    .usersByUsernameQuery(
	     "select username, password, enabled from users where username=?")
	    .authoritiesByUsernameQuery(
	     "select username, role from users where username=?");
	}
}