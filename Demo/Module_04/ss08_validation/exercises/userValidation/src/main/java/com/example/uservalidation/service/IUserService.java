package com.example.uservalidation.service;

import com.example.uservalidation.model.User;
import com.example.uservalidation.repository.UserRepository;


import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> findAll();
    Optional<User> findById(int id);

    void save(User user);

    void remove(int id);
}
