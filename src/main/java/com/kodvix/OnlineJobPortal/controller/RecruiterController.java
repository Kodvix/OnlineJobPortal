package com.kodvix.OnlineJobPortal.controller;

import com.kodvix.OnlineJobPortal.dto.RecruiterProfileRegisterDto;
import com.kodvix.OnlineJobPortal.dto.RecruiterProfileResponseDto;
import com.kodvix.OnlineJobPortal.service.RecruiterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recruiters")
public class RecruiterController {

    @Autowired
    private RecruiterService recruiterService;

    @PostMapping("/register")
    public ResponseEntity<RecruiterProfileResponseDto> registerRecruiter(@RequestBody RecruiterProfileRegisterDto dto) {
        RecruiterProfileResponseDto response = recruiterService.createProfile(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/profile/{userId}")
    public ResponseEntity<RecruiterProfileResponseDto> getRecruiterProfile(@PathVariable Long userId) {
        RecruiterProfileResponseDto response = recruiterService.getProfileByUserId(userId);
        return ResponseEntity.ok(response);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<RecruiterProfileResponseDto> updateRecruiterProfile(
            @PathVariable Long id,
            @RequestBody @Valid RecruiterProfileRegisterDto dto) {
        RecruiterProfileResponseDto response = recruiterService.updateProfile(id, dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<RecruiterProfileResponseDto>> getAllRecruiters() {
        return ResponseEntity.ok(recruiterService.getAllProfiles());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRecruiter(@PathVariable Long id) {
        recruiterService.deleteProfile(id);
        return ResponseEntity.ok("Recruiter deleted successfully");
    }
}
