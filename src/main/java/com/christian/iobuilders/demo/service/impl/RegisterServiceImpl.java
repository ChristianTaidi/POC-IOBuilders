package com.christian.iobuilders.demo.service.impl;

import com.christian.iobuilders.demo.pojos.User;
import com.christian.iobuilders.demo.repository.UserRepository;
import com.christian.iobuilders.demo.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;


@Service
@Configurable
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private UserRepository userRepository;


    /**
     * This method stores a new user in the database generating an id
     * @param user The parameter user is sent to the controller as JSON
     *            and interpreted as OBJECT
     * @return Returns the user with the new id
     */
    @Override
    public User register(User user) {

        if(credentialCheck(user)){
            userRepository.save(user);
        }
        return user;
    }

    private boolean credentialCheck(User user){
        //ToDo verify user input
        return true;
    }

}
