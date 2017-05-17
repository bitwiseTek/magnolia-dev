package com.bitwise.magnolia.web.security.config;
/**
 *  
 * @author Sika Kay
 * @date 19/02/17
 *
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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
	
	/*@Autowired 
	private Environment env;*/
	

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
		http
				.headers().addHeaderWriter(new StaticHeadersWriter("X-Content-Security-Policy", "script-src 'self'"))
				.addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Origin", "*"))
				.addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE"))
				.addHeaderWriter(new StaticHeadersWriter("Access-Control-Max-Age", "3600"))
				.addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Headers", "x-requested-with")).and()
				.sessionManagement().sessionFixation().newSession().and().authorizeRequests()
				.antMatchers("/", "/index", "/auth/login",  "/users/register", "/defaulterror", "/resourceNotFound",
						"/dataAccessFailure", "/accessdenied", "/page-not-found")
				.permitAll()
				.antMatchers("/admin/**", "/users/**", "/courses/**", "/course/**", "/programmes/**", 
						"/programme/categories/**")
				.authenticated().antMatchers("/admin/**","/courses/**", "/course/**", "/programmes/**", 
						"/programme/categories/**")
				.access("hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
				.antMatchers("/students/**")
				.access("hasRole('STUDENT')")
				.antMatchers("/staff/**")
				.access("hasRole('STAFF')")
				.and().formLogin().loginPage("/auth/login")
				.loginProcessingUrl("/j_spring_security_check").usernameParameter("username")
				.passwordParameter("password")
				.failureHandler(new AuthenticationFailureHandler() {
					
					@Override
					public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
							throws IOException, ServletException {
						if (exception instanceof BadCredentialsException) {
							response.sendRedirect("/magnolia/auth/login?error");
						} else if (exception.getClass().isAssignableFrom(DisabledException.class)) {
							response.sendRedirect("/magnolia/auth/login?deactivated");
						} else {
							response.sendRedirect("/magnolia/auth/login?locked");
						}
					}
				})
				.defaultSuccessUrl("/")
				.and()
				.logout().logoutUrl("/auth/logout")
				.logoutSuccessHandler(new LogoutSuccessHandler() {
					
					@Override
					public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
							throws IOException, ServletException {
						auth = SecurityContextHolder.getContext().getAuthentication();
						if (auth != null) {
							new SecurityContextLogoutHandler().logout(request, response, auth);
						}
						response.sendRedirect("/magnolia/auth/login?logout");
					}
				})
				.invalidateHttpSession(true).deleteCookies("JSESSIONID").and().httpBasic().realmName("Magnolia Web")
				.and().csrf().disable().exceptionHandling().accessDeniedPage("/accessdenied");
	}
	
	protected void configureRestful(HttpSecurity http) throws Exception {
	http
			 
			.headers().addHeaderWriter(new StaticHeadersWriter("X-Content-Security-Policy", "script-src 'self'"))
			.addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Origin", ""))
			.addHeaderWriter(
					new StaticHeadersWriter("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE"))
			.addHeaderWriter(new StaticHeadersWriter("Access-Control-Max-Age", "3600"))
			.addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Headers", "x-requested-with")).and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
			.antMatchers("/api/v1/mg/restful/auth/login", "/api/v1/mg/restful/states/", "/api/v1/mg/restful/lgas/", 
					"/api/v1/mg/restful/users/register")
			.permitAll()
			.antMatchers("/api/v1/mg/restful/users/profile", "/api/v1/mg/restful/students/**", "/api/v1/mg/restful/staff/**")
			.authenticated().antMatchers("/api/v1/mg/restful/users/", "/api/v1/mg/restful/students/", "/api/v1/mg/restful/staff/")
			.access("hasRole('SUPER_ADMIN')")
			.antMatchers("/api/v1/mg/restful/users/", "/api/v1/mg/restful/students/", "/api/v1/mg/restful/staff/")
			.access("hasRole('ADMIN')").and().formLogin()
			.loginPage("/api/v1/mg/restful/auth/login").loginProcessingUrl("/j_spring_security_check")
			.usernameParameter("username").passwordParameter("password").defaultSuccessUrl("/")
			.failureUrl("/api/v1/mg/restful/auth/login?error").and().logout().logoutUrl("/api/v1/mg/restful/auth/logout")
			.logoutSuccessUrl("/api/v1/mg/restful/auth/login?signout").invalidateHttpSession(true)
			.deleteCookies("JSESSIONID").and().httpBasic().realmName("Magnolia Mobile").and().csrf().disable()
			.exceptionHandling().accessDeniedPage("/api/v1/mg/restful/accessdenied");
}

	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
}
