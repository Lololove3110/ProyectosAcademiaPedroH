package com.studentApp.finalProject.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http
	        .csrf().disable()  // Disable CSRF for API if necessary
	        .authorizeHttpRequests(configurer ->
            configurer
                    .requestMatchers("/api/students/GetStudent{id}", "/api/students/{id}/average").hasAnyRole("STUDENT", "TEACHER", "ADMIN")
                    .requestMatchers("/api/students/getStudents", "/api/students/pass", "/api/students/fail").hasAnyRole("TEACHER", "ADMIN")
                    .requestMatchers("/api/students/CreateStudent", "/api/students/{id}").hasRole("ADMIN")
                    .anyRequest().authenticated()
    )
	        
	        
	        .httpBasic()  // Enable basic authentication for API requests
	        .and()
	        .formLogin(form ->
	            form
	                .loginPage("/showMyLoginPage")  // Custom login page for form-based login
	                .loginProcessingUrl("/authenticateTheUser")
	                .permitAll()
	        )
	        .logout(logout -> logout.permitAll())  // Allow logout for everyone
	        .exceptionHandling(configurer -> configurer.accessDeniedPage("/access-denied"));  // Custom access denied page

	    return http.build();
	}


    @Bean
    public UserDetailsManager userDetailsManager() {
        UserDetails student1 = User.builder()
                .username("student1")
                .password("{noop}password1")
                .roles("STUDENT")
                .build();

        UserDetails teacher1 = User.builder()
                .username("teacher1")
                .password("{noop}password2")
                .roles("TEACHER")
                .build();

        UserDetails admin1 = User.builder()
                .username("admin1")
                .password("{noop}password3")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(student1, teacher1, admin1);
    }
}
