/**
 * 
 */
/**
 * @author js4otto
 *
 */
package com.bitwise.magnolia.web.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.security.config.BeanIds;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.DispatcherServlet;

import com.bitwise.magnolia.config.InfrastructureContextConfig;
import com.bitwise.magnolia.config.MailConfig;
import com.bitwise.magnolia.config.TestDataContextConfiguration;
import com.bitwise.magnolia.web.restful.config.SwaggerConfig;
import com.bitwise.magnolia.web.security.config.SecurityConfig;
	 
public class MagnoliaInitializer implements WebApplicationInitializer {
	
	private static final Class<?>[] basicConfigurationClasses = new Class<?>[] {
		WebMvcConfig.class, InfrastructureContextConfig.class,
		TestDataContextConfiguration.class, MailConfig.class, 
		SecurityConfig.class, SwaggerConfig.class};

	private static final String DISPATCHER_SERVLET_NAME = "dispatcher";
		
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
	   	registerListener(servletContext);	    	
	    registerDispatcherServlet(servletContext);
    	registerOpenEntityManagerInViewFilter(servletContext);
	   	registerHiddenHttpMethodFilter(servletContext);
	   	registerCharacterEncodingFilter(servletContext);
	   	registerSpringSecurityFilterChain(servletContext);
	}
	
	private void registerDispatcherServlet(ServletContext servletContext) {
		AnnotationConfigWebApplicationContext dispatcherContext = createContext(WebMvcConfig.class);
		ServletRegistration.Dynamic dispatcher;
		dispatcher = servletContext.addServlet(DISPATCHER_SERVLET_NAME, new DispatcherServlet(dispatcherContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}

	private void registerListener(ServletContext servletContext) {
		AnnotationConfigWebApplicationContext rootContext = createContext(basicConfigurationClasses);
		servletContext.addListener(new ContextLoaderListener(rootContext));
		servletContext.addListener(new RequestContextListener());
	}

    private void registerOpenEntityManagerInViewFilter(ServletContext servletContext) {
    	FilterRegistration.Dynamic registration = servletContext.addFilter("openEntityManagerInView",
    			new OpenEntityManagerInViewFilter());
    	registration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD), false,
    			"*.htm");
    	registration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD), false,
    			"/j_spring_security_check");
    }

    private void registerHiddenHttpMethodFilter(ServletContext servletContext) {
    	FilterRegistration.Dynamic registration;
    	registration = servletContext.addFilter("hiddenHttpMethodFilter", HiddenHttpMethodFilter.class);
    	registration.addMappingForServletNames(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD), false,
    			"dispatcher");
    }

    private void registerCharacterEncodingFilter(ServletContext servletContext) {
    	FilterRegistration.Dynamic registration;
    	registration = servletContext.addFilter("characterEncodingFilter", CharacterEncodingFilter.class);
    	registration.setInitParameter("encoding", "utf-8");
    	registration.setInitParameter("forceEncoding", "true");
    	registration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD), false, "/*");
    }
    
    private void registerSpringSecurityFilterChain(ServletContext servletContext) {
    	FilterRegistration.Dynamic springSecurityFilterChain = servletContext.addFilter(BeanIds.SPRING_SECURITY_FILTER_CHAIN, new DelegatingFilterProxy());
    	springSecurityFilterChain.addMappingForUrlPatterns(null, false, "/*");
    }
   
    private AnnotationConfigWebApplicationContext createContext(final Class<?>... annotatedClasses) {
    	AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
    	context.register(annotatedClasses);
    	return context;
    }
}
