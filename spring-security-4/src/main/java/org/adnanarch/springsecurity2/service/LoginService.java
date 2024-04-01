package org.adnanarch.springsecurity2.service;

import org.adnanarch.springsecurity2.dto.CustomerDto;

public interface LoginService {
    boolean createUser(CustomerDto customerDto);
}
