package com.christian.iobuilders.demo.service.impl;

import com.christian.iobuilders.demo.pojos.User;
import com.christian.iobuilders.demo.repository.UserRepository;
import com.christian.iobuilders.demo.service.ClaimDeployService;
import com.christian.iobuilders.demo.service.CredentialsGenService;
import com.christian.iobuilders.demo.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
@Configurable
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private CredentialsGenService credentialsGen;

    @Autowired
    private UserRepository userRepository;

    @Override
    public String register(User user) {
        Map credentials = credentialsGen.generateCredentials(user.getPassword());
        user.setCredentials(credentials);
        userRepository.save(user);
        //ToDo generate user credentials
        //ToDo store user credentials in database
        return "User created";
    }

}
