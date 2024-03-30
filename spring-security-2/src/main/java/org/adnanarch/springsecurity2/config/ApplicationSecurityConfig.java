package org.adnanarch.springsecurity2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ApplicationSecurityConfig {

    // use requestMatchers() to specify the requests that should be handled by this filter chain
    // use authenticated for protected requests
    // use permitAll() to public all requests

    // Default code in documentation

    /*
     * @Bean SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
     * http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
     * http.formLogin(withDefaults());
     * http.httpBasic(withDefaults());
     * return http.build();
     * }
     */

    /*Without Lambda DSL --> Deprecated Now
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests()
                .requestMatchers("/myAccount", "/myBalance", "myCards", "myLoans").authenticated()
                .requestMatchers("/contact", "/notice").permitAll()
                .and().formLogin()
                .and().httpBasic();
        return http.build();
    }*/

    // With Lambda DSL Latest Code
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/myBalance", "/myLoans", "/myCards", "myAccount").authenticated()
                        .requestMatchers("/contact", "/notice").permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    /*For some reason if you want to deny all the requests then
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests((requests -> requests.anyRequest().denyAll()))
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }*/
}
