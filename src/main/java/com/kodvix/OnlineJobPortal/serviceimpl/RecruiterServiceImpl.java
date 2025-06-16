package com.kodvix.OnlineJobPortal.serviceimpl;

import com.kodvix.OnlineJobPortal.dto.RecruiterProfileRegisterDto;
import com.kodvix.OnlineJobPortal.dto.RecruiterProfileResponseDto;
import com.kodvix.OnlineJobPortal.entity.Recruiter;
import com.kodvix.OnlineJobPortal.entity.User;
import com.kodvix.OnlineJobPortal.enums.Role;
import com.kodvix.OnlineJobPortal.repository.RecruiterRepository;
import com.kodvix.OnlineJobPortal.repository.UserRepository;
import com.kodvix.OnlineJobPortal.service.RecruiterService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecruiterServiceImpl implements RecruiterService {

    @Autowired
    private RecruiterRepository recruiterRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    @Override
    public RecruiterProfileResponseDto createProfile(RecruiterProfileRegisterDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // ❗ Role check
        if (user.getRole() != Role.RECRUITER) {
            throw new RuntimeException("Only users with RECRUITER role can create recruiter profile.");
        }


        recruiterRepository.findByUserId(dto.getUserId()).ifPresent(r -> {
            throw new RuntimeException("Recruiter profile already exists for this user.");
        });

        Recruiter recruiter = new Recruiter();
        recruiter.setUser(user);
        recruiter.setCompanyName(dto.getCompanyName());
        recruiter.setDesignation(dto.getDesignation());
        recruiter.setCompanyWebsite(dto.getCompanyWebsite());
        recruiter.setCompanyAddress(dto.getCompanyAddress());
        recruiter.setContactNumber(dto.getContactNumber());
        recruiter.setCompanyEmail(dto.getCompanyEmail());

        Recruiter saved = recruiterRepository.save(recruiter);
        return mapToResponseDto(saved);
    }



    @Override
    public RecruiterProfileResponseDto getProfileByUserId(Long userId) {
        Recruiter recruiter = recruiterRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Recruiter profile not found"));
        return mapToResponseDto(recruiter);
    }


    @Override
    public RecruiterProfileResponseDto updateProfile(Long id, RecruiterProfileRegisterDto dto) {
        Recruiter recruiter = recruiterRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Recruiter not found"));

        recruiter.setCompanyName(dto.getCompanyName());
        recruiter.setDesignation(dto.getDesignation());
        recruiter.setCompanyWebsite(dto.getCompanyWebsite());
        recruiter.setCompanyAddress(dto.getCompanyAddress());
        recruiter.setContactNumber(dto.getContactNumber());
        recruiter.setCompanyEmail(dto.getCompanyEmail());

        Recruiter updated = recruiterRepository.save(recruiter);
        return mapToResponseDto(updated);
    }

    @Override
    public List<RecruiterProfileResponseDto> getAllProfiles() {
        return recruiterRepository.findAll().stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteProfile(Long id) {
        Recruiter recruiter = recruiterRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Recruiter not found"));
        recruiterRepository.delete(recruiter);
    }

    private RecruiterProfileResponseDto mapToResponseDto(Recruiter recruiter) {
        RecruiterProfileResponseDto dto = new RecruiterProfileResponseDto();
        dto.setId(recruiter.getId());
        dto.setCompanyName(recruiter.getCompanyName());
        dto.setDesignation(recruiter.getDesignation());
        dto.setCompanyWebsite(recruiter.getCompanyWebsite());
        dto.setCompanyAddress(recruiter.getCompanyAddress());

        User user = recruiter.getUser();
        dto.setUserId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());

        return dto;
    }
}
