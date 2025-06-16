package com.kodvix.OnlineJobPortal.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobRequestDto {
    private String title;
    private String description;
    private String location;
    private String jobType;
    private Double salary;
    private String experienceLevel;
    private Long recruiterId; // Recruiter who is posting
}
