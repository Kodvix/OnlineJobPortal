package com.kodvix.OnlineJobPortal.service;

import com.kodvix.OnlineJobPortal.dto.LoginRequestDto;
import com.kodvix.OnlineJobPortal.dto.LoginResponseDto;
import com.kodvix.OnlineJobPortal.dto.UserRegisterDto;
import com.kodvix.OnlineJobPortal.dto.UserResponseDto;
import com.kodvix.OnlineJobPortal.entity.User;

import java.util.List;

public interface UserService {

        UserResponseDto updateUser(Long id, UserRegisterDto userDto);
        UserResponseDto getUserById(Long id);
        List<UserResponseDto> getAllUsers();
        void deleteUser(Long id);
        UserResponseDto registerUser(UserRegisterDto registerDto);
        LoginResponseDto loginUser(LoginRequestDto loginRequestDto);
}
