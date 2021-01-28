package com.christian.iobuilders.demo.service.impl;

import com.christian.iobuilders.demo.pojos.User;
import com.christian.iobuilders.demo.repository.UserRepository;
import com.christian.iobuilders.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long userId) {
        Optional user = userRepository.findById(userId);
        if(user.isPresent() && user.get().getClass()==User.class){
            return (User)user.get();
        }else {
            return null;
        }
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
