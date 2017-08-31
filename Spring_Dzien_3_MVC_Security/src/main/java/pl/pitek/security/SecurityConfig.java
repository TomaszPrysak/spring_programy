package pl.pitek.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http.authorizeRequests()
			// nieuwierzytelnione dla poniższego url ("/")
			.antMatchers("/").permitAll() // adres "niebezpieczny
			// uwierzytelnienie dla każdego innego adresu url niz ten który jest powyżej ("/")
			.anyRequest().authenticated()
			// korzystamy z dostępnego przez springa formularza logowania (a nie z przeglądarkowego)
			//.and().formLogin().permitAll()
		// korzystamy z naszego własnego ekranu logowania
		.and().formLogin().loginPage("/logowanie").permitAll()
			// ponieważ wykorzystujemy naszego ekranu logowania musimy stworzyć "pośrednią" nieistniejącą stronę która mogłaby przechowywać nasze dane przekazywane w formularzu logowania i jeżeli chcielibysmy je gdzieś dalej przetwarzać. Po to ją tworzymy, ale obecnie nic z tymi wartościami nie będziemy robić
			.loginProcessingUrl("/processLogin").permitAll()
		// wylogowywanie, tutaj w przypadku tak jak w logonie też podajey pośredni nieistniejący adres url do wylogowania, następnie wskazujemy adres url do którego się przeniesiemy po wylogowaniu, oczywiście musi to być w strefie niebezpiecznej
		.and().logout().logoutUrl("/logout").logoutSuccessUrl("/").permitAll();
	}
	
}
