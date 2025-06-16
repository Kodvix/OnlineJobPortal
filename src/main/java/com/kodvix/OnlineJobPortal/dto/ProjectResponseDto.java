package com.kodvix.OnlineJobPortal.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectResponseDto {
    private Long id;
    private String title;
    private String description;
    private String skillsRequired;
    private Double budget;
    private String duration;
    private Long recruiterId;
    private String recruiterCompany;
}
