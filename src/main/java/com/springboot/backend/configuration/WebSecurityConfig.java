package com.springboot.backend.configuration;

import com.springboot.userservice.services.UserService;
import com.springboot.userservice.utils.ConfigUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig
        extends WebSecurityConfigurerAdapter {


    private final UserService userService;

    private final UserDetailsService userDetailsService;

    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().configurationSource(request -> {
            CorsConfiguration cors = new CorsConfiguration();
            cors.setAllowedOrigins(List.of("http://localhost:3000"));
            cors.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
            cors.setAllowedHeaders(List.of("*"));
            return cors;
        });

//      http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.formLogin().loginPage("/login").permitAll();

//        http.authorizeRequests().antMatchers("/login").permitAll();
//        // .and().formLogin()
//        // .loginProcessingUrl("/api/v1/login");
//
//        // only allow authenticated users to access the rest of the application
//        http.authorizeRequests()
//                .antMatchers("/api/users/**")
//                .hasAnyAuthority("ROLE_ADMIN");
//        http.authorizeRequests().anyRequest().authenticated();

        // apply filter for authentication and authorization
//        JwtTokenUtils tokenUtils = new JwtTokenUtils();
//        JwtAuthenticationFilter filter = new JwtAuthenticationFilter(userService, authenticationManagerBean(),
//                tokenUtils);
//        // filter.setFilterProcessesUrl("/api/v1/login");
//        http.addFilter(filter);
//        http.addFilterBefore(new UserAuthorizationFilter(tokenUtils),
//                UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    // tell spring how to look for users and check passwords
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(ConfigUtils.passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().configurationSource(request -> {
            CorsConfiguration cors = new CorsConfiguration();
            cors.setAllowedOrigins(List.of("http://localhost:3000"));
            cors.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
            cors.setAllowedHeaders(List.of("*"));
            return cors;
        });
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeRequests().antMatchers("/login").permitAll();

        http.formLogin().loginPage("/login").permitAll();
        // .loginProcessingUrl("/api/v1/login");

        // only allow authenticated users to access the rest of the application
        http.authorizeRequests()
                .antMatchers("/api/users/**")
                .hasAnyAuthority("ROLE_ADMIN");
//        http.authorizeRequests().anyRequest().authenticated();

        // apply filter for authentication and authorization
        com.springboot.userservice.utils.JwtTokenUtils tokenUtils = new com.springboot.userservice.utils.JwtTokenUtils();
        com.springboot.userservice.filter.JwtAuthenticationFilter filter = new com.springboot.userservice.filter.JwtAuthenticationFilter(userService, authenticationManagerBean(),
                tokenUtils);
        // filter.setFilterProcessesUrl("/api/v1/login");
//        http.addFilter(filter);
//        http.addFilterBefore(new com.springboot.userservice.filter.UserAuthorizationFilter(tokenUtils),
//                UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
