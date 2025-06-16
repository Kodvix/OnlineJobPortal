package com.kodvix.OnlineJobPortal.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecruiterProfileResponseDto {

    @NotNull(message = "Recruiter ID cannot be null")
    private Long id;

    @NotBlank(message = "Company name cannot be blank")
    private String companyName;

    @NotBlank(message = "Designation cannot be blank")
    private String designation;

    @NotBlank(message = "Company website cannot be blank")
    private String companyWebsite;

    @NotBlank(message = "Company address cannot be blank")
    private String companyAddress;

    @NotNull(message = "User ID cannot be null")
    private Long userId;

    @NotBlank(message = "First name cannot be blank")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    private String lastName;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email cannot be blank")
    private String email;

}
