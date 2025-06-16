package com.kodvix.OnlineJobPortal.serviceimpl;

import com.kodvix.OnlineJobPortal.dto.LoginRequestDto;
import com.kodvix.OnlineJobPortal.dto.LoginResponseDto;
import com.kodvix.OnlineJobPortal.dto.UserRegisterDto;
import com.kodvix.OnlineJobPortal.dto.UserResponseDto;
import com.kodvix.OnlineJobPortal.entity.User;
import com.kodvix.OnlineJobPortal.enums.Role;
import com.kodvix.OnlineJobPortal.repository.UserRepository;
import com.kodvix.OnlineJobPortal.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    private UserResponseDto convertToResponseDto(User user) {
        return modelMapper.map(user, UserResponseDto.class);
    }

    private User convertToEntity(UserRegisterDto dto) {
        return modelMapper.map(dto, User.class);
    }

    @Override
    public UserResponseDto updateUser(Long id, UserRegisterDto userDto) {
        Optional<User> existing = userRepository.findById(id);
        if (existing.isEmpty()) {
            throw new RuntimeException("User not found with id: " + id);
        }

        User user = existing.get();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setConfirmPassword(userDto.getConfirmPassword());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setCountry(userDto.getCountry());
        user.setState(userDto.getState());
        user.setCity(userDto.getCity());

        // ✅ Set role only if userDto has one (optional)
        if (userDto.getRole() != null) {
            user.setRole(userDto.getRole());
        }

        User updated = userRepository.save(user);
        return convertToResponseDto(updated);
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return convertToResponseDto(user);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public LoginResponseDto loginUser(LoginRequestDto loginRequestDto) {
        User user = userRepository.findByEmail(loginRequestDto.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or user not found"));

        if (!user.getPassword().equals(loginRequestDto.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        LoginResponseDto responseDto = new LoginResponseDto();
        responseDto.setUserId(user.getId());
        responseDto.setName(user.getFirstName() + " " + user.getLastName());
        responseDto.setRole(user.getRole()); // ✅ Send role in response
        responseDto.setMessage("Welcome to my WebSite");

        return responseDto;
    }

    @Override
    public UserResponseDto registerUser(UserRegisterDto registerDto) {
        if (userRepository.findByEmail(registerDto.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        if (!registerDto.getPassword().equals(registerDto.getConfirmPassword())) {
            throw new RuntimeException("Passwords do not match");
        }

        User user = convertToEntity(registerDto);


        if (registerDto.getRole() == null) {
            throw new RuntimeException("User role must be provided");
        }

        user.setRole(registerDto.getRole());
        user.setCreatedAt(new Date());

        User savedUser = userRepository.save(user);
        return convertToResponseDto(savedUser);
    }
}
