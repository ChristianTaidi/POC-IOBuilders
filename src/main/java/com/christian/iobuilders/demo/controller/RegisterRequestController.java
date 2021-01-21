package com.christian.iobuilders.demo.controller;

import com.christian.iobuilders.demo.pojos.User;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

public interface RegisterRequestController {

    ResponseEntity createUser(User user, Model model);
    ResponseEntity addPicture(@RequestBody MultipartFile image);
}
