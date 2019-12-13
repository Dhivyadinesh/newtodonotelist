package com.dd.service;

import com.dd.entity.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);

}
