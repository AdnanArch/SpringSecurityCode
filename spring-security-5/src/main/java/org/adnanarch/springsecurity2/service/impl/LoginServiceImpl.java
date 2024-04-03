package org.adnanarch.springsecurity2.service.impl;

import org.adnanarch.springsecurity2.dto.CustomerDto;
import org.adnanarch.springsecurity2.model.Customer;
import org.adnanarch.springsecurity2.repository.CustomerRepository;
import org.adnanarch.springsecurity2.service.LoginService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginServiceImpl(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean createUser(CustomerDto customerDto) {
        boolean result = false;

        String email = customerDto.getEmail();

        List<Customer> customers = customerRepository.findByEmail(email);
        if (customers.isEmpty()){
            Customer customer = dtoToCustomer(customerDto);
            String hashedPassword = passwordEncoder.encode(customer.getPwd());
            customer.setPwd(hashedPassword);
            customerRepository.save(customer);
            result = true;
        }

        return result;
    }

    private Customer dtoToCustomer(CustomerDto customerDto){
        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        customer.setEmail(customerDto.getEmail());
        customer.setPwd(customerDto.getPwd());
        customer.setRole(customerDto.getRole());
        return customer;
    }
}
