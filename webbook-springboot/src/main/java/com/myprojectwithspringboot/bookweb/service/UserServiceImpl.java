package com.myprojectwithspringboot.bookweb.service;

import com.myprojectwithspringboot.bookweb.model.User;
import com.myprojectwithspringboot.bookweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void insertUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User searchUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
