package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration   //Spring 설정 클래스임을 나타냄 → 빈으로 등록되어 동작
public class SecurityConfig {

    //비밀번호 암호화 - BCrypt 인코더 이용
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {

        return new BCryptPasswordEncoder();
    }

    //CORS 설정 - 프론트엔드와 연동 가능하게 함
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOriginPattern(CorsConfiguration.ALL);          //요청 보내는 쪽의 도메인 주소
        corsConfiguration.addAllowedMethod(CorsConfiguration.ALL);
        corsConfiguration.addAllowedHeader(CorsConfiguration.ALL);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }

    //CSRF, formLogin, httpBasic 비활성화 - REST API 방식에서는 불필요하므로 제거
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors(Customizer.withDefaults());        //위에서 만든 Cors 적용
        http.csrf(csrf -> csrf.disable());
        http.formLogin(formLogin -> formLogin.disable());
        http.httpBasic(httpBasic -> httpBasic.disable());
        http.logout(logout -> logout.disable());
        //무상태 방식 사용 - 세션 비활성화
        //STATELESS → JWT 방식 사용 시 필수
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        //권한 설정 - permit 만 허용 / 이외는 모두 인증 필요
        http.authorizeHttpRequests(auth -> {
            auth.requestMatchers("/auth/signup").permitAll();    //요청주소 - 허용할 주소
            auth.anyRequest().authenticated();                 //위에 주소 제외 모든 요청은 인증필요
        });
        return http.build();
    }
}

