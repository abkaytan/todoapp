package com.coderspace.todoapp.security;

import com.coderspace.todoapp.service.Impl.UserDetailsImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsImp userDetailsImp;


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public WebSecurityConfig(UserDetailsImp userDetailsImp, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsImp = userDetailsImp;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http
//                .httpBasic().and()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.POST, "/api/todoapp/**").hasRole("ADMIN")
//                .antMatchers(HttpMethod.PUT, "/api/todoapp/**").hasRole("ADMIN")
//                .antMatchers(HttpMethod.PATCH, "/api/todoapp/**").hasRole("ADMIN").and()
//                .csrf().disable();
//    }

//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.cors().and().csrf().disable().authorizeRequests().antMatchers("/v2/api-docs",
//                        "/configuration/ui",
//                        "/swagger-resources/**",
//                        "/configuration/security",
//                        "/swagger-ui.html","/api/todoapp/register",
//                        "/api/todoapp/sign-in",
//                        "/h2-console/**",
//                        "/h2-console",
//                        "/webjars/**").permitAll()
//
//                .anyRequest().authenticated().and()
//                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
//                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
//                // this disables session creation on Spring Security
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.headers().frameOptions().disable();
//    }
    /*@Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL).permitAll()
                .antMatchers(HttpMethod.POST, SecurityConstants.LOGIN).permitAll()
//                .antMatchers("/h2-console", "/h2-console/**","/console/**").permitAll()
//                .antMatchers("/","/api/**", "/api/sign-in").permitAll()
//                .antMatchers("/v2/api-docs",
//                        "/configuration/ui",
//                        "/swagger-resources/**",
//                        "/configuration/security",
//                        "/swagger-ui.html",
//                        "/swagger-ui.html#/",
//                        "/swagger-ui.html#/**",
//                        "/webjars/**").permitAll()
                .antMatchers("/h2-console", "/h2-console/**","/console/**").permitAll() //buradan itibaren yeni eklemeler
                .antMatchers("/","/api/**", "/api/todoapp/sign-in","/api/todoapp/register").permitAll()
                .antMatchers("/swagger-ui.html#/customer-controller/saveCustomerUsingPOST").permitAll()
                .antMatchers("/swagger-ui.html#/login-controller/signInUsingPOST").permitAll()
                .antMatchers("/v2/api-docs",
                        "/configuration/ui",
                        "/swagger-resources/**",
                        "/configuration/security",
                        "/swagger-ui.html", "/index", "/login", "/adduser",
                        "/webjars/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                // this disables session creation on Spring Security
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.headers().frameOptions().disable();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsImp).passwordEncoder(bCryptPasswordEncoder);
        auth.inMemoryAuthentication()
                .withUser("abkode")
                .password("pass")
                .roles("ADMIN");
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }

}
