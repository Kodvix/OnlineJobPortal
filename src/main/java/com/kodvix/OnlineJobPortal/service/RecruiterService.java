package com.kodvix.OnlineJobPortal.service;

import com.kodvix.OnlineJobPortal.dto.RecruiterProfileRegisterDto;
import com.kodvix.OnlineJobPortal.dto.RecruiterProfileResponseDto;

import java.util.List;

public interface RecruiterService {
    RecruiterProfileResponseDto createProfile(RecruiterProfileRegisterDto dto);
    RecruiterProfileResponseDto getProfileByUserId(Long userId);
    RecruiterProfileResponseDto updateProfile(Long id, RecruiterProfileRegisterDto dto);
    List<RecruiterProfileResponseDto> getAllProfiles();
    void deleteProfile(Long id);
}
