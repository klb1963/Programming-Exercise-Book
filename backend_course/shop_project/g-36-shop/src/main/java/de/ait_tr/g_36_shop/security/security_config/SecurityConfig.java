package de.ait_tr.g_36_shop.security.security_config;

import de.ait_tr.g_36_shop.security.sec_filter.TokenFilter;
import io.swagger.v3.oas.annotations.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    // field - наш собственный фильтр
    private TokenFilter filter;

    // constructor
    public SecurityConfig(TokenFilter filter) {
        this.filter = filter;
    }

    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer :: disable)
                .sessionManagement(x -> x
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // отключили сессии
                .httpBasic(AbstractHttpConfigurer::disable) // отключили базовую авторизацию
                .addFilterAfter(filter, UsernamePasswordAuthenticationFilter.class) // добавили свой фильтр
                .authorizeHttpRequests(x -> x
//                        .requestMatchers(HttpMethod.GET, "/products/all").permitAll()
//                        .requestMatchers(HttpMethod.GET, "/products").hasAnyRole("ADMIN", "USER")
//                        .requestMatchers(HttpMethod.POST, "/products").hasRole("ADMIN")
//                        .requestMatchers(HttpMethod.POST, "/auth/login", "/auth/refresh").permitAll() // разрешаем всем доступ к этим endpoints
                                .anyRequest().permitAll()
                ).build();
    }
}
