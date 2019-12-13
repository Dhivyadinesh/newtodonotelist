package com.dd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dd.entity.User;
import com.dd.repository.Userrepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private Userrepository userRepository;

    @Override
    public void save(User user) {
        user.setPassword(user.getPassword());
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
