package com.christian.iobuilders.demo.controller.impl;

import com.christian.iobuilders.demo.controller.RegisterRequestController;
import com.christian.iobuilders.demo.pojos.User;
import com.christian.iobuilders.demo.service.RegisterService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Base64;

@Controller
public class RegisterRequestControllerImpl implements RegisterRequestController {


    @Autowired
    private RegisterService registerService;


    @Override
    @PostMapping(value = "/register")
    public ResponseEntity<User> createUser(@RequestBody User user, Model model) {

        registerService.register(user);
        //ToDo Call user management service
        return null;
    }

    @Override
    @PostMapping(value = "/uploadPicture", produces = "application/json")
    public ResponseEntity<User> addPicture(@RequestBody MultipartFile image){
        //ToDo check user input
        //ToDo Call user management service
        return null;
    }
}