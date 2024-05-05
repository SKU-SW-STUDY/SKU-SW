package sku.lesson.blog.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import sku.lesson.blog.service.UserDetailService;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@RequiredArgsConstructor
@Configuration
public class WebSecurityConfig {

    private final UserDetailService userSerivce;

    @Bean   // 스프링 시큐리티 기능 비활성화할 URL
    public WebSecurityCustomizer configure(){
        return (web) -> web.ignoring()
                .requestMatchers(toH2Console())
                .requestMatchers("/static/**");
    }

    @Bean   // 특정 HTTP 요청에 대한 웹 기반 보안 구성
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests((authorizeRequests)->       // 권한 요청
                authorizeRequests
                        .requestMatchers("/login", "/signup", "/user").permitAll()
                        .anyRequest().authenticated()
        ).formLogin((formLogin)->               // formLogin -> 로그인 성공시 /articles 페이지로 이동
                formLogin
                        .loginPage("/login")
                        .defaultSuccessUrl("/articles")
        ).logout((logout)->         // 로그아웃 기능
                logout
                        .logoutSuccessUrl("/login")
                        .invalidateHttpSession(true)
        ).csrf((csrf)->         // csrf 설정 비활성화
                csrf.disable());

        return http.build();
    }

    @Bean   // 인증 관리자 관련 설정
    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder) throws Exception{

        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userSerivce)
                .passwordEncoder(bCryptPasswordEncoder)
                .and().build();
    }

    @Bean   // 패스워드 인코더로 사용할 빈 등록
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
