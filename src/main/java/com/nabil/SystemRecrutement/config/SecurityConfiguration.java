package com.nabil.SystemRecrutement.config;
// .anyRequest().authenticated()


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.session.SessionManagementFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.nabil.SystemRecrutement.filters.JwtAuthenticationFilters;
import com.nabil.SystemRecrutement.filters.JwtAuthorizationFilter;
import com.nabil.SystemRecrutement.model.AppUser;
import com.nabil.SystemRecrutement.service.AccountService;
import com.nabil.SystemRecrutement.services.auth.ApplicationUserDetailsService;



@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{


	  @Autowired
	  private ApplicationUserDetailsService applicationUserDetailsService;

	  @Autowired
	  private ApplicationRequestFilter applicationRequestFilter;

	  @Override
	  
	  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		  // défifnt un objet qui s'appelle userDetailsService : c'est un service fournit par spring 
		  // on doit creé pour que le spring qu'elle doit faire pour authentifier cette utilisateur
		  // userDetailsService : va utiliser le service applicationUserDetailsService
	    auth.userDetailsService(applicationUserDetailsService)
	    .passwordEncoder(passwordEncoder())
	    ;
	  }

	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http.addFilterBefore(corsFilter(), SessionManagementFilter.class)
	        .csrf().disable()
	        .authorizeRequests().antMatchers("/**/authenticate",
	        // "/**/systemrecrutement/v1/**" , 
	        "/**/entreprises/create",
	        "/v2/api-docs",
	        "/swagger-resources",
	        "/swagger-resources/**",
	        "/configuration/ui",
	        "/configuration/security",
	        "/swagger-ui.html",
	        "/webjars/**",
	        "/v3/api-docs/**",
	        "/swagger-ui/**").permitAll()
	        .and().sessionManagement()
	        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	    ;

	    http.addFilterBefore(applicationRequestFilter, UsernamePasswordAuthenticationFilter.class);
	  }

	  
	 
	  @Bean
	  public AuthenticationManager customAuthenticationManager() throws Exception {
	    return authenticationManagerBean();
	  }

	  @Bean(name = "passwordEncoder")
	  public static  PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	 
	  
	  
	  
	  
	  
	  
	  
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  @Override
	  public void configure(WebSecurity web) {
	      web.httpFirewall(defaultHttpFirewall());
	  }
	   
	  @Bean
	  public HttpFirewall defaultHttpFirewall() {
	      return new DefaultHttpFirewall();
	  }
	  
	   
	  
	  @Bean  
	  public CorsFilter corsFilter() {
	    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    final CorsConfiguration config = new CorsConfiguration();
	    config.setAllowCredentials(true);
	    config.setAllowedOriginPatterns(Collections.singletonList("*"));
	    config.setAllowedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization"));
	    config.setAllowedMethods(Arrays.asList( "GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH"));
	    source.registerCorsConfiguration("/**", config);
	    return new CorsFilter(source);
	  }

	  
	
}

