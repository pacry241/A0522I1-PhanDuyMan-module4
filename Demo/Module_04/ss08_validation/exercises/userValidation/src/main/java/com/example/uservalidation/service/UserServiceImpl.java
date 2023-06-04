package com.example.uservalidation.service;

import com.example.uservalidation.model.User;
import com.example.uservalidation.repository.UserRepository;
import com.example.uservalidation.validator.PhoneNumberValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    PhoneNumberValidator phoneNumberValidator;
    @Override
    public List<User> findAll() {
        Iterable<User> iterable =userRepository.findAll();
        List<User> blogListList = new ArrayList<>();
        for (User b: iterable) {
            blogListList.add(b);
        }
        return blogListList;
    }

    @Override
    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }
    /*@Override
    public List<Blog> getList() {
        Iterable<Blog> iterable = iBlogRepository.findAll(); //Iterable: dùng để sắp xếp;
        List<Blog> blogListList = new ArrayList<>();
        for (Blog b: iterable) {
            blogListList.add(b);
        }
        return blogListList;
    }*/

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void remove(int id) {
        userRepository.deleteById(id);
    }
}
