package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	PasswordEncoder encoder;
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	UserDetailsService userDetailsService;

	/*
	 * @Override protected void gconfigure(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * 
	 * 
	 * auth.inMemoryAuthentication().withUser("admin").password(encoder.encode(
	 * "1234")).roles("ADMIN","MANAGER");
	 * auth.inMemoryAuthentication().withUser("manager").password(encoder.encode(
	 * "1234")).roles("MANAGER");
	 * 
	 * 
	 * 
	 * 
	 * auth.jdbcAuthentication() .dataSource(dataSource)
	 * .usersByUsernameQuery("select username as principal, password as credentials, actived from users "
	 * + "where username = ? ")
	 * .authoritiesByUsernameQuery("select users_username as principal, roles_role as role from users_roles"
	 * + " where users_username =?") .rolePrefix("ROLE_"); }
	 * 
	 * 
	 * 
	 */
	@Autowired
	public void globalConfig(AuthenticationManagerBuilder auth, DataSource datasource) throws Exception {
		
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/LoginVrai").permitAll()
				.defaultSuccessUrl("/index");

		http.exceptionHandling().accessDeniedPage("/403");
	}
}
