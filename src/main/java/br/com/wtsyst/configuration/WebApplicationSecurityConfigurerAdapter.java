package br.com.wtsyst.configuration;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity(debug = false)
public class WebApplicationSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

	private final Properties users = new Properties();
	
	private final PasswordEncoder chave = new BCryptPasswordEncoder();

	/* Configuracao do spring security */
	// https://docs.spring.io/spring-security/site/docs/current/reference/html/jc.html
	// https://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.formLogin().loginPage("/login.jsf");
		http.formLogin().loginProcessingUrl("/login.jsf");
		http.formLogin().defaultSuccessUrl("/index.jsf");
		http.formLogin().failureUrl("/login.jsf?source=loginError");
		http.formLogin().permitAll();
		
		http.authorizeRequests().antMatchers("/resources/**", "/javax.faces.resource/**").permitAll();
		http.logout().logoutUrl("/logout").logoutSuccessUrl("/login.jsf?source=logout").permitAll();
		
		
		http.authorizeRequests().antMatchers("/gerenciar_requisicoes.jsf").hasAnyRole("ADMINISTRADOR");
		
		
	

		
		http.authorizeRequests().anyRequest().authenticated();
		
	
		http.csrf().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
		auth.inMemoryAuthentication()
		.withUser("root")
		.password(chave.encode("root"))
		.roles("COORDENADOR", "ADMINISTRADOR")
		.and().passwordEncoder(chave);
		
	
	}
	
}