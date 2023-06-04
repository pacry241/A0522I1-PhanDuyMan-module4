package com.example.demo.dto;


import lombok.*;

import java.util.List;
@Data
@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private Long id;

    private String email;

    private String password;

    private String phone;

    private List<Long> idRole;

    private String firstName;

    private String lastName;
}
