package com.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.inMemoryAuthentication().withUser("maniteja").password("{noop}maniteja").authorities("Manager");
	auth.inMemoryAuthentication().withUser("saikiran").password("{noop}saikiran").authorities("Cashier");
	auth.inMemoryAuthentication().withUser("priyanka").password("{noop}priyanka").authorities("Clerk");

}
@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http.authorizeRequests()
		.antMatchers("/login").permitAll()
		.antMatchers("/home").authenticated()
		.antMatchers("/loan").hasAuthority("Manager")
		.antMatchers("/deposit").hasAuthority("Cashier")
		.antMatchers("/balance").hasAuthority("Clerk")
		.anyRequest().authenticated()

		
		.and()
		.formLogin()
		.defaultSuccessUrl("/home", true)
		.and()
		.logout()
		
		.and()
		.exceptionHandling()
		.accessDeniedPage("/denied");
		
		
		
}
}