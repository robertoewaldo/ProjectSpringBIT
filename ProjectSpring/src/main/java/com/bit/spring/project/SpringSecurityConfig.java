package com.bit.spring.project;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.bit.spring.project.entity.User;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	public SpringSecurityConfig() {
        super();
    }
	
	@Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
            .dataSource(dataSource)
            .usersByUsernameQuery("select username, password, enabled from users where username=?")
            .authoritiesByUsernameQuery("select username, role from users where username=?")
        ;
    }
	
//	@Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//            .anyRequest().authenticated()
//            .and()
//            .formLogin().loginPage("/login").defaultSuccessUrl("/home", true).permitAll()
//            .and()
//            .logout().permitAll();     
//    }
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
		        .authorizeRequests()
		        .antMatchers("/admin/**").hasRole("ADMIN")
		        .antMatchers("/anonymous*").anonymous()
		        .antMatchers("/login*").permitAll()
		        .antMatchers("/resources/**").permitAll()
		        .anyRequest().authenticated()
	        .and()
		        .formLogin()
		        .loginPage("/login")
		        .loginProcessingUrl("/perform_login")
		        .defaultSuccessUrl("/home", true)
		        //.failureHandler(authenticationFailureHandler())
	        .and()
		        .logout()
		        .logoutUrl("/perform_logout")
		        .deleteCookies("JSESSIONID");
    }
    
//    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
////    	
////    	List<User> list = DB.getAllUser();
////    	
////    	for(int i = 0; i < list.size(); i ++) {
////    		auth.inMemoryAuthentication()
////            .withUser(list.get(i).getUsername()).password(passwordEncoder().encode(list.get(i).getPassword())).roles("USER");
////    	}
//    	
//        auth.inMemoryAuthentication()
//            .withUser("user5").password(passwordEncoder().encode("user5Pass")).roles("USER")
//            .and()
//            .withUser("user2").password(passwordEncoder().encode("user2Pass")).roles("USER")
//            .and()
//            .withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN");
//    }
    
//    @Bean
//    public AuthenticationFailureHandler authenticationFailureHandler() {
//        return new CustomAuthenticationFailureHandler();
//    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

