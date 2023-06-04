package com.example.demo.service;

import com.example.demo.model.Role;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface RoleService  {
    List<Role> getAllRole();
    Optional<Role> findRoleById(Long id);

}
