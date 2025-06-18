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

    @NotNull(message = "Resume cannot be null")
    private String uploadResume;
    @NotNull(message = "Skills cannot be null")
    private String skills;
    private String preferedDomain;
    private String expectedCTC;
    private String preferedLocation;
    @NotNull(message = "ProfileSummary cannot be null")
    private String profileSummary;
    private String portfolioLink;
    @NotNull(message = "Education cannot be null")
    private String education;
    @NotNull(message = "Experience cannot be null")
    private String experience;
    @NotNull(message = "Certifications cannot be null")
    private String certifications;
    private String availabilityToJoin;

    @NotNull(message = "UserId is required")
    private Long userId;
}
