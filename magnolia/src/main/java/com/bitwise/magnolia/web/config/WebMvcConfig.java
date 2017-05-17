/**
 * 
 */
/**
 * @author js4otto
 *
 */
package com.bitwise.magnolia.web.config;

import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.js.ajax.AjaxUrlBasedViewResolver;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
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
import com.bitwise.magnolia.util.converter.PermissionConverter;
import com.bitwise.magnolia.util.converter.RoleConverter;
import com.bitwise.magnolia.util.converter.StaffToSubjectConverter;
import com.bitwise.magnolia.util.converter.StudentToCourseConverter;
import com.bitwise.magnolia.web.security.CredentialValidation;
import com.bitwise.magnolia.web.security.MagnoliaAuthenticationProvider;
import com.bitwise.magnolia.web.security.MagnoliaUserContext;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.bitwise.magnolia")
public class WebMvcConfig extends WebMvcConfigurerAdapter{
     
	private static final long MAX_FILE_UPLOAD_SIZE = 1024 * 1024 * 15;
    private static final int FILE_SIZE_THRESHOLD = 1024 * 1024;
	
    @Bean
    public ViewResolver tilesViewResolver() {
    	UrlBasedViewResolver urlBasedVR = new AjaxUrlBasedViewResolver();
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
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**/*").addResourceLocations("/resources/");
    }
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/index");
    }
    
    @Bean
    public SchoolInterceptor schoolInterceptor(){
    	return new SchoolInterceptor();
    }
    
    //Registration of Paths that we want to Intercept
    //public void addInterceptors(InterceptorRegistry registry){
    //	registry.addInterceptor(schoolInterceptor()).addPathPatterns("/**/*")
    //												.addPathPatterns("/**");
    //}

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolver){
    	exceptionResolver.add(simpleMappingExceptionResolver());
    }
    
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver(){
    	SimpleMappingExceptionResolver exceptionResolver;
    	exceptionResolver = new SimpleMappingExceptionResolver();
    	Properties mappings = new Properties();
    	mappings.setProperty("DataAccessException", "dataAccessError");
    	mappings.setProperty("AccessDeniedException", "accessdenied");
    	mappings.setProperty("NoSuchRequestHandlingException", "resourceNotFound");
    	mappings.setProperty("TypeMismatchException", "resourceNotFound");
    	mappings.setProperty("MissingServletRequestParameterException", "resourceNotFound");
    	mappings.setProperty("PageNotFound", "resourceNotFound");
    	mappings.setProperty("NoValidDaysException", "schooldeactivated");
    	Properties statusCodes = new Properties();
    	mappings.setProperty("auth/login", String.valueOf(HttpServletResponse.SC_UNAUTHORIZED));
    	//exceptionResolver.setDefaultErrorView("defaulterror");
    	//exceptionResolver.setExceptionMappings(mappings);
    	exceptionResolver.setStatusCodes(statusCodes);
    	return exceptionResolver;
    }
    
    @Bean
    public MultipartResolver multipartResolver(){
    	CommonsMultipartResolver resolver = new CommonsMultipartResolver();
    	resolver.setMaxUploadSize(MAX_FILE_UPLOAD_SIZE);
    	resolver.setMaxInMemorySize(FILE_SIZE_THRESHOLD);
    	return resolver;
    }
    
    @Bean
    public MessageSource messageSource(){
    	ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    	messageSource.setBasename("classpath:/messages");
    	messageSource.setUseCodeAsDefaultMessage(true);
    	return messageSource;
    }
    
    @Bean
    public RoleConverter roleToUserConverter() {
    	return new RoleConverter();
    }
    
    @Bean
    public PermissionConverter permissionToRoleConverter() {
    	return new PermissionConverter();
    }
    
    @Bean
    public StudentToCourseConverter studentToCourseConverter() {
    	return new StudentToCourseConverter();
    }
    
    @Bean
    public StaffToSubjectConverter staffToSubjectConverter() {
    	return new StaffToSubjectConverter();
    }
    
    @Bean
    public MagnoliaAuthenticationProvider authenticationProvider() {
    	return new MagnoliaAuthenticationProvider();
    }
    
    @Bean
   	public BCryptPasswordEncoder passwordEncoder() {
   		return new BCryptPasswordEncoder();
   	}
    
    @Bean
    public CredentialValidation credentialValidation() {
    	return new CredentialValidation();
    }
    
    @Bean
    public MagnoliaUserContext userContext() {
    	return new MagnoliaUserContext();
    }
    
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(roleToUserConverter());
        registry.addConverter(permissionToRoleConverter());
        registry.addConverter(studentToCourseConverter());
        registry.addConverter(staffToSubjectConverter());
    }
}
