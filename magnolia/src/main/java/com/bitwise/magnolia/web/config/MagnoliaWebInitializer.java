package com.bitwise.magnolia.web.config;
/**
 *  
 * @author Sika Kay
 * @date 14/02/17
 *
 */

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MagnoliaWebInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext container) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(WebMvcContextConfig.class);
		ctx.setServletContext(container);
 
		ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));
 
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
    }
}
