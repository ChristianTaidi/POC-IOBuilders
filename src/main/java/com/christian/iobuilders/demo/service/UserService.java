package com.christian.iobuilders.demo.service;

import com.christian.iobuilders.demo.pojos.User;

import java.util.List;

public interface UserService {

    List<User> getAll();
    User getById(Long userId);
    void saveUser(User user);

}
