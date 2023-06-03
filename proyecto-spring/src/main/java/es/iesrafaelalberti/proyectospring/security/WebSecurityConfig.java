package es.iesrafaelalberti.proyectospring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    //@Bean
    //public WebSecurityCustomizer webSecurityCustomizer() {
    @Bean
    SecurityFilterChain filterChain (HttpSecurity http, AuthenticationManager authManager) throws Exception{
        return http
                .csrf().disable()// Desabilitar el csrf
                .authorizeRequests()// En cuanto a las reglas de las solicitudes,
                .anyRequest()// cualquier solicitud
                .authenticated()// debe estar autenticada
                .and()
                .httpBasic()// Autentificación básica, usuario y contra
                .and()
                .httpBasic()
                .and()
                .sessionManagement()// Gestión de las sesiones
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)// establecer la política de la creación de las sesiones, sin estado
                .and()
                .build();
        // return (web) -> web.ignoring().anyRequest();
    }
    @Bean
    UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("admin")
                .password(passwordEncoder().encode("admin"))
                .roles()
                .build());
        return manager;
    }
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
