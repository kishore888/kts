package com.hospitality.config;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.annotation.Order;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration
@EnableWebSecurity
//@EnableWebMvcSecurity
//@EnableGlobalMethodSecurity(prePostEnabled=true)
@ImportResource("/WEB-INF/spring-servlet.xml")
public class SpringWebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Resource(name = "UserService")
	private UserService userService;
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//            ShaPasswordEncoder encoder = new ShaPasswordEncoder();
            auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
//            auth.userDetailsService(userService);
	}
	
//	@Override
//	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//	    ObjectMapper mapper = new ObjectMapper();
//	    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//	    converters.add(new MappingJackson2HttpMessageConverter(mapper));
//	}
	
	@Bean
	public Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder() {
	    Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
	    builder.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	    return builder;
	}
	
//  //1. Default
//  //Default configuration in WebSecurityConfigurerAdapter
//  protected void configure(HttpSecurity http) throws Exception {
//   http
//    .authorizeRequests()
//     .anyRequest().authenticated()
//     .and()
//    .formLogin()
//     .and()
//    .httpBasic();
//  }
    
//	@Override
//	  public void configure(WebSecurity web) throws Exception {
//	    web
//	      .ignoring()
//	         .antMatchers("/scripts/**","/styles/**","/images/**","/error/**");
//	  }
	
//    @Bean
//    public UserDetailsService userDetailsService() {
//	   InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//	   manager.createUser(User.withUsername("kishore").password("123").roles("USER").build());
//	   return manager;
//    }
 
    @Configuration
    @Order(1)
    public static class ApiWebSecurityConfig extends WebSecurityConfigurerAdapter {
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	        	.headers()
	        	.addHeaderWriter(new XFrameOptionsHeaderWriter(XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))
	        	.and()
	        	.authorizeRequests()
	        	.antMatchers("/login","/login.jsp","/images/**","/matrixAdmin/**","/js/**","/css/**")
	        	.permitAll()
	        	.antMatchers("/**")
	        	.authenticated()
	        	.and()
	        	.formLogin()
	        	.loginProcessingUrl("/j_spring_security_check")
	        	.loginPage("/login")
	        	.defaultSuccessUrl("/dashboard", true)
	        	.usernameParameter("username")
	        	.passwordParameter("password")
	        	.failureUrl("/login?error=true")
	        	.and()
	        	.logout()
	        	.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	        	.deleteCookies("JSESSIONID")
	        	.invalidateHttpSession(true)
	        	.logoutSuccessUrl("/login")
	        	.and()
	        	.sessionManagement()
	        	.invalidSessionUrl("/login")
	        	.and()
	        	.csrf()
	        	.disable();
	    }
    }
}
