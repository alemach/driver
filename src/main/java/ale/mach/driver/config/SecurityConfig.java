package ale.mach.driver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.httpBasic()
				.and()
				.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/**", "/**").permitAll()
				.antMatchers(HttpMethod.POST).hasRole("ADMIN")
				.antMatchers(HttpMethod.PUT).hasRole("ADMIN")
				.antMatchers(HttpMethod.DELETE).hasRole("ADMIN")
				.and()
				.csrf().disable();
//				.formLogin().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
				.inMemoryAuthentication()
				.passwordEncoder(NoOpPasswordEncoder.getInstance())
				.withUser("admin")
				.password("qwerty")
				.roles("ADMIN");
	}
}
