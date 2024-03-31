package org.adnanarch.springsecurity2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

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

    /*
    Approach 2
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
    }*/


    /*Leveraging the JDBC */

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
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
