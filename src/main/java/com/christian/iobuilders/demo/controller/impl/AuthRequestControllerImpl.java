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

@Controller
public class AuthRequestControllerImpl implements AuthRequestController {


    @Autowired
    private RegisterService registerService;


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