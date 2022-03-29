package com.example.project.security;

//import com.example.project.appuser.AppUserService;

import com.example.project.security.filters.CustomAuthenticationFIlter;
import com.example.project.security.filters.CustomAuthorizationFilter;
import com.google.common.collect.ImmutableList;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final BCryptPasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;




    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.cors().configurationSource(corsConfigurationSource());
        http.sessionManagement().sessionCreationPolicy(STATELESS);
//        http.authorizeRequests().anyRequest().permitAll();
        http.authorizeRequests().antMatchers("/login","/appuser/refreshtoken/**").permitAll();
//        http.authorizeRequests().antMatchers(HttpMethod.GET, "/admin").hasAnyAuthority("ADMIN");
       http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(new CustomAuthenticationFIlter(authenticationManagerBean()));
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
        http.exceptionHandling().authenticationEntryPoint(
                new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(ImmutableList.of("http://localhost:3000"));
        configuration.setAllowedMethods(ImmutableList.of("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowCredentials(true);
 //       configuration.setAllowedHeaders(ImmutableList.of("Authorization", "Cache-Control", "Content-Type"));
        configuration.setAllowedHeaders(ImmutableList.of("*"));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }


}
