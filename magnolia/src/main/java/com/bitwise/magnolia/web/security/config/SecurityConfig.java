package com.bitwise.magnolia.web.security.config;
/**
 *  
 * @author Sika Kay
 * @date 19/02/17
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.header.writers.StaticHeadersWriter;

import com.bitwise.magnolia.web.security.MagnoliaAuthenticationProvider;
import com.bitwise.magnolia.web.security.MagnoliaUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MagnoliaAuthenticationProvider authenticationProvider;

	@Autowired
	private MagnoliaUserDetailsService userDetailsService;

	/*
	 * @Autowired private Environment env;
	 */

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider);
		auth.userDetailsService(userDetailsService);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/favico.ico", "/resources/**/*");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http// .requiresChannel().anyRequest().requiresSecure()
			// .and()
				/*
				 * .portMapper().http(Integer.parseInt(env.getProperty(
				 * "http.port",
				 * "8080"))).mapsTo(Integer.parseInt(env.getProperty(
				 * "https.port", "8443"))) .and()
				 */
				.headers().addHeaderWriter(new StaticHeadersWriter("X-Content-Security-Policy", "script-src 'self'"))
				.addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Origin", "*"))
				.addHeaderWriter(
						new StaticHeadersWriter("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE"))
				.addHeaderWriter(new StaticHeadersWriter("Access-Control-Max-Age", "3600"))
				.addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Headers", "x-requested-with")).and()
				.sessionManagement().sessionFixation().newSession().and().authorizeRequests()
				.antMatchers("/", "/index", "/users/login",  "/defaulterror", "/resourceNotFound",
						"/dataAccessFailure")
				.permitAll()
				.antMatchers("/courses/**", "/projects/**", "/users/**", "/students/**")
				.authenticated().antMatchers("/admin/**", "/users/searchusers", "/users/searchusersdialog", 
						"/users/createuser", "/students/createstudent", "/students/searchstudents", 
						"/users/edituser", "/users/searchuserdialog", "/courses/searchcourses", 
						"/projects/searchprojects", "/staff/createstaff")
				.access("hasRole('ADMINISTRATOR') or hasRole('SUPER_ADMIN')").and().formLogin().loginPage("/auth/login")
				.loginProcessingUrl("/j_spring_security_check").usernameParameter("username")
				.passwordParameter("password").defaultSuccessUrl("/index.htm").failureUrl("/auth/login?error").and()
				.logout().logoutUrl("/auth/logout").logoutSuccessUrl("/auth/login?logout")
				.invalidateHttpSession(true).deleteCookies("JSESSIONID").and().httpBasic().realmName("Magnolia Web")
				.and().csrf().and().exceptionHandling().accessDeniedPage("/accessdenied");
	}

	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
}
