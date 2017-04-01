/**
 * 
 */
/**
 * @author js4otto
 *
 */
package com.bitwise.magnolia.config;

import java.util.Properties;
import java.util.concurrent.ThreadPoolExecutor;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
 
@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.bitwise.magnolia" })
@EnableAspectJAutoProxy(proxyTargetClass=true)
@PropertySource(value = { "classpath:application.properties" })
public class InfrastructureContextConfig {
 
	@Autowired
    private Environment environment;
	
	@Bean
	public DataSource jpaDataSource() {
		DriverManagerDataSource source = new DriverManagerDataSource();
		source.setDriverClassName(environment.getRequiredProperty("db.driverClassName"));
        source.setUrl(environment.getRequiredProperty("db.url"));
        source.setUsername(environment.getRequiredProperty("db.username"));
        source.setPassword(environment.getRequiredProperty("db.password"));
		return source;
	}
	
	@Bean
	public Properties jpaProperties() {
		Properties props = new Properties();
		props.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		props.put("hibernate.hbm2dll.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		props.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		props.put("hibernate.cache.use_second_level_cache", true);
		props.put("hibernate.cache.region.factory_class", org.hibernate.cache.ehcache.EhCacheRegionFactory.class.getName());
		
		//c3p0 Settings
		props.put("hibernate.c3p0.min_size", environment.getRequiredProperty("hibernate.c3p0.min_size"));
		props.put("hibernate.c3p0.max_size", environment.getRequiredProperty("hibernate.c3p0.max_size"));
		props.put("hibernate.c3p0.timeout", environment.getRequiredProperty("hibernate.c3p0.timeout"));
		props.put("hibernate.c3p0.max_statements", environment.getRequiredProperty("hibernate.c3p0.max_statements"));
		props.put("hibernate.c3p0.idle_test_period", environment.getRequiredProperty("hibernate.c3p0.idle_test_period"));
		return props;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean emf() {
		LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
		lef.setJpaProperties(jpaProperties());
		lef.setDataSource(jpaDataSource());
		lef.setJpaVendorAdapter(this.jpaVendorAdapter());
		return lef;
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter hJpa = new HibernateJpaVendorAdapter();
		hJpa.setGenerateDdl(true);
		hJpa.setShowSql(true);
		return hJpa;
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(emf().getObject());
	}
	
	@Bean
	public ThreadPoolTaskExecutor taskExecutor() {
		return new ThreadPoolTaskExecutor() {
			private static final long serialVersionUID = 1L;

		{
			setCorePoolSize(15);
			setMaxPoolSize(25);
			setQueueCapacity(50);
			setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		}};
	}
}