package pl.reaktor.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			// dostęp nieautoryzowany do podstron naszego bloga 
			.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/contact").permitAll()
				.antMatchers("/registerForm").permitAll()
				.antMatchers("/blog").permitAll()
				.antMatchers("/errorPage").permitAll()
				.antMatchers("/saveRegister").permitAll()
				.antMatchers("/success").permitAll()
				.antMatchers("/add").permitAll()
			// dostęp do postron naszego bloga po autoryzacji
			.anyRequest().authenticated()
				.and().formLogin().loginPage("/loginForm").permitAll()
				.loginProcessingUrl("/processlogin").permitAll()
			.and().logout().logoutUrl("/logout").logoutSuccessUrl("/").permitAll();;
	}
	
}
