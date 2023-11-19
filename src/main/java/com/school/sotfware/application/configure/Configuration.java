package com.school.sotfware.application.configure;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@org.springframework.context.annotation.Configuration
@PropertySource("classpath:/application.yml")
public class Configuration extends WebSecurityConfigurerAdapter {
	private ApplicationContext applicationContext = new AnnotationConfigApplicationContext();
	private UserDetailsService userDetailsService;
	private AuthenticationDetailsSource authenticationDetailsSource;

	//CORS 설정 빈 등록
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.addAllowedOriginPattern("*");
		configuration.addAllowedMethod("*");
		configuration.addAllowedHeader("*");
		configuration.setAllowCredentials(true);
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);	
		return source;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth
//				.authenticationProvider(authenticationProvider());
//	}

//	private AuthenticationProvider authenticationProvider() {
//		return  new CustomAuthenticationProvider();
//	}

	@Override
	public void configure(WebSecurity web) throws Exception { // js , image 등 정적인 자원 보안 미 적용
		web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
		web.httpFirewall(defaultHttpFirewall());
	}

	@Bean
	public HttpFirewall defaultHttpFirewall() {
		return new DefaultHttpFirewall();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.cors().configurationSource(corsConfigurationSource())
				.and()
				.csrf().disable() // 추후 수정

				.authorizeRequests()
				.antMatchers("/**").permitAll()
//                .antMatchers("/board").hasRole("USER") //각각의 사용자는 자신의 권한에 허용된 페이지만 접근이 가능하다.
				.anyRequest().authenticated();

	}
	@Bean
	public PasswordEncoder passwordEncoder() { //평문 비밀번호를 암호화
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

}
