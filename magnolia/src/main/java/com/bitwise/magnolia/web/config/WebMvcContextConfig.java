package com.bitwise.magnolia.web.config;
/**
 *  
 * @author Sika Kay
 * @date 14/02/17
 *
 */
import java.util.Properties;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

import com.bitwise.magnolia.interceptors.SchoolInterceptor;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages={"com.bitwise.magnolia"})
public class WebMvcContextConfig extends WebMvcConfigurerAdapter {

	private static final long MAX_FILE_UPLOAD_SIZE = 1024 * 1024 * 15;
	
    private static final int FILE_SIZE_THRESHOLD = 1024 * 1024;
    
	@Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**/*").addResourceLocations("/resources/");
    }

	@Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        registry.addViewController("/index.htm").setViewName("index");
    }
	
    @Override
    public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:/messages");
        messageSource.setUseCodeAsDefaultMessage(true);
        return messageSource;
    }
    
    @Bean
    public SchoolInterceptor schoolInterceptor(){
    	return new SchoolInterceptor();
    }
    
    @Bean
    public MultipartResolver multipartResolver(){
    	CommonsMultipartResolver resolver = new CommonsMultipartResolver();
    	resolver.setMaxUploadSize(MAX_FILE_UPLOAD_SIZE);
    	resolver.setMaxInMemorySize(FILE_SIZE_THRESHOLD);
    	return resolver;
    }
    
    //Registration of Paths that we want to Intercept
    public void addInterceptors(InterceptorRegistry registry){
    	registry.addInterceptor(schoolInterceptor()).addPathPatterns("/**/*")
    												.addPathPatterns("/**");
    }
    
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver(){
    	SimpleMappingExceptionResolver simpleResolver = new SimpleMappingExceptionResolver();
    	Properties mappings = new Properties();
    	
    	//When a ResourceNotFoundException is thrown any where in the application
    	//This mapping specifies the page to display
    	mappings.setProperty("ResourceNotFoundException", "page-not-found");
    	//mappings.setProperty("AuthenticationException", "redirect:/");
    	
    	//When a NoValidDaysException is thrown any where in the application
    	//This mapping specifies the page to display
    	mappings.setProperty("NoValidDaysException", "/school-deactivated");
    	//mappings.setProperty("LimitedPrivilegeException", "home");

    	Properties statusCodes = new Properties();
    	//mappings.setProperty("{school_name}/login", String.valueOf(HttpServletResponse.SC_UNAUTHORIZED));
    	
    	simpleResolver.setExceptionMappings(mappings);
    	simpleResolver.setStatusCodes(statusCodes);
    	return simpleResolver;
    }
    
    @Bean
    public ViewResolver tilesViewResolver() {
    	UrlBasedViewResolver urlBasedVR = new UrlBasedViewResolver();
    	urlBasedVR.setOrder(1);
    	urlBasedVR.setViewClass(TilesView.class);
    	return urlBasedVR;
    }
    
    @Bean
    public ViewResolver viewResolver() {
    	InternalResourceViewResolver internalResourceVR = new InternalResourceViewResolver();
    	internalResourceVR.setOrder(2);
    	internalResourceVR.setPrefix("/WEB-INF/views");
    	internalResourceVR.setSuffix(".htm");
    	internalResourceVR.setViewClass(JstlView.class);
    	return internalResourceVR;
    }
    
    @Bean
    public TilesConfigurer tilesConfigurer() {
    	TilesConfigurer tilesConfigurer = new TilesConfigurer();
    	tilesConfigurer.setDefinitions(new String[] {"/WEB-INF/tiles/tiles-configuration.xml"});
    	return tilesConfigurer;
    }
    
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DateFormatter("yy-MM-dd"));
    }
}
