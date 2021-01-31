package com.christian.iobuilders.demo.controller.impl;

import com.christian.iobuilders.demo.controller.AuthRequestController;
import com.christian.iobuilders.demo.pojos.User;
import com.christian.iobuilders.demo.service.RegisterService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * controller used for authentication processes
 * Login not implemented
 */
@Controller
public class AuthRequestControllerImpl implements AuthRequestController {


    @Autowired
    private RegisterService registerService;


    /**
     * Post endpoint used to create a new user in the system
     * It takes a user json objecto from the request body like
     *
     * URL is localhost:8080/register
     * {
     *     "dni":"12345678B",
     *     "name":"Test",
     *     "email":"test@mail",
     *     "password":"password"
     * }
     *
     *
     * @param user
     * @return
     */
    @Override
    @PostMapping(value = "/register")
    public ResponseEntity<User> createUser(@RequestBody User user) {

        User result = registerService.register(user);
        if (result.getId() != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);

        }else{
            return new ResponseEntity("Error",HttpStatus.NOT_ACCEPTABLE);
        }

    }




}