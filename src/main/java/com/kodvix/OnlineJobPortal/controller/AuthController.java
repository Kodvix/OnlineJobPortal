package com.kodvix.OnlineJobPortal.controller;

import com.kodvix.OnlineJobPortal.dto.LoginRequestDto;
import com.kodvix.OnlineJobPortal.dto.LoginResponseDto;
import com.kodvix.OnlineJobPortal.dto.UserRegisterDto;
import com.kodvix.OnlineJobPortal.dto.UserResponseDto;
import com.kodvix.OnlineJobPortal.entity.User;
import com.kodvix.OnlineJobPortal.service.UserService;
import lombok.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(@RequestBody UserRegisterDto dto) {
        UserResponseDto user = userService.registerUser(dto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {
        LoginResponseDto loginResponseDto= userService.loginUser(loginRequestDto);
        return new ResponseEntity<>(loginResponseDto, HttpStatus.OK);
    }
}
