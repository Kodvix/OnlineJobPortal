package com.kodvix.OnlineJobPortal.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class JobSeekerDto {
    //private long freelancerId;
    @NotNull(message = "First name is required")
    private String firstName;
    @NotNull(message = "Last name is required")
    private String lastName;
    @NotNull(message = "Email is required")
    private String email;
    @NotNull(message = "PhoneNo is required")
    private String phoneNo;
    @NotNull(message = "Resume is required")
    private String uploadResume;
    @NotNull(message = "DateOfBirth is required")
    private String dateOfBirth;
    private String skills;
    private String education;
    private String experience;
    private String address;

    @NotNull(message = "UserId is required")
    private Long userId;
}
