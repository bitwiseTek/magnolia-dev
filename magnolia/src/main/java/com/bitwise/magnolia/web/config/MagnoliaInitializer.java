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
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.DispatcherServlet;

import com.bitwise.magnolia.web.security.config.SecurityConfig;
	 
public class MagnoliaInitializer implements WebApplicationInitializer {
		
    public void onStartup(ServletContext container) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(WebMvcConfig.class, SecurityConfig.class);
		registerOpenEntityManagerInViewFilter(container);
		registerHiddenHttpMethodFilter(container);
		registerCharacterEncodingFilter(container);
		registerSpringSecurityFilterChain(container);
		ctx.setServletContext(container);
 
		ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));
 
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
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
}
