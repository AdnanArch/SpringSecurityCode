package org.adnanarch.springsecurity2.config;

import org.adnanarch.springsecurity2.model.Customer;
import org.adnanarch.springsecurity2.repository.CustomerRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EasyBankUserDetails implements UserDetailsService {
    private final CustomerRepository customerRepository;

    public EasyBankUserDetails(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Customer> customer = customerRepository.findByEmail(username);
        if (customer.isEmpty()) {
            throw new UsernameNotFoundException("User details not found for" + username);
        }
        String userName = customer.get(0).getEmail();
        String password = customer.get(0).getPwd();
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(customer.get(0).getRole()));

        return new User(userName, password, authorities);
    }
}
