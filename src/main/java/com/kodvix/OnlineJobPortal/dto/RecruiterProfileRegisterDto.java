package com.kodvix.OnlineJobPortal.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecruiterProfileRegisterDto {

    @NotNull(message = "User ID cannot be null")
    private Long userId;

    @NotBlank(message = "Company name cannot be blank")
    private String companyName;

    @NotBlank(message = "Designation cannot be blank")
    private String designation;

    @NotBlank(message = "Company website cannot be blank")
    private String companyWebsite;

    @NotBlank(message = "Company address cannot be blank")
    private String companyAddress;

    private String contactNumber;

    private String companyEmail;
}
