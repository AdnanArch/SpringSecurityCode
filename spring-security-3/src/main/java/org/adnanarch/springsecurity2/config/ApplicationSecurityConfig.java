package org.adnanarch.springsecurity2.config;

import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ApplicationSecurityConfig {
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

    /*Approach 1 where we use withDefaultPasswordEncoder() method while creating userDetails
    @Bean
    public InMemoryUserDetailsManager userDetailService(){
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .authorities("admin")
                .build();
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("user")
                .authorities("user")
                .build();
        return new InMemoryUserDetailsManager(admin, user);
    }*/

    // Approach 2
    @Bean
    public InMemoryUserDetailsManager userDetailService(){
        InMemoryUserDetailsManager detailsManager = new InMemoryUserDetailsManager();
        UserDetails admin = User.withUsername("admin")
                .password("admin")
                .authorities("admin")
                .build();
        UserDetails user = User.withUsername("user")
                .password("user")
                .authorities("read")
                .build();

        detailsManager.createUser(admin);
        detailsManager.createUser(user);

        return detailsManager;
    }


    /**
     *
     * NoOpPasswordEncoder is Not recommended for Production Grade Apps
     * Use only for non-production
     *
     * @return PasswordEncoder
     *
     * */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

}
