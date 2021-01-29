package com.christian.iobuilders.demo.service.impl;

import com.christian.iobuilders.demo.pojos.User;
import com.christian.iobuilders.demo.repository.UserRepository;
import com.christian.iobuilders.demo.service.RegisterService;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;


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

        if(user==null){
            throw new NullPointerException("Null User");
        }
        if(user.getDni().length()<8 || user.getDni().length()>14){
            throw new InvalidParameterException("DNI length is not correct");
        }
        if(!EmailValidator.getInstance().isValid(user.getEmail())){
            throw new InvalidParameterException("Email is invalid");
        }
        return true;
    }

}
