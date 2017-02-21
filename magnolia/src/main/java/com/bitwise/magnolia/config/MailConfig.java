package com.bitwise.magnolia.config;
/**
 *  
 * @author Sika Kay
 * @date 19/02/17
 *
 */
import java.util.Properties;

import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan("com.bitwise.magnolia.service.email")
public class MailConfig {

	@Bean
	public JavaMailSenderImpl mailSender(Environment env) {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(env.getProperty("email.host"));
		mailSender.setPort(Integer.parseInt(env.getProperty("email.port")));
		mailSender.setProtocol(env.getProperty("email.protocol"));
		mailSender.setUsername(env.getProperty("email.username"));
		mailSender.setPassword(env.getProperty("email.password"));
		mailSender.setJavaMailProperties(new Properties() {
			private static final long serialVersionUID = 1L;
		{
			setProperty("mail.smtp.auth", "true");
			setProperty("mail.debug", "true");
			setProperty("mail.smtp.port", "587");
			setProperty("mail.smtp.starttls.enable", "true");
			setProperty("mail.smtp.socketFactory.port", "587");
			setProperty("mail.smtp.quitwait", "false");
			setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		}});
		return mailSender;
	}
	
	@Bean
	public VelocityEngineFactoryBean velocityEngine() {
		VelocityEngineFactoryBean velocityEngine = new VelocityEngineFactoryBean();
		Properties props = new Properties();
		props.setProperty("resource.loader", "class");
		props.setProperty("class.resource.loader.class", ClasspathResourceLoader.class.getName());
		velocityEngine.setVelocityProperties(props);
		return velocityEngine;
	}
}
