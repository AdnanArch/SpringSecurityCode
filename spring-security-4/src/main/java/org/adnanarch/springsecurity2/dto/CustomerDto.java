package org.adnanarch.springsecurity2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class CustomerDto {
    private Integer id;
    private String email;
    private String pwd;
    private String role;
}
