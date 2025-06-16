package com.kodvix.OnlineJobPortal.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectRequestDto {

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    @NotBlank(message = "Skills required is mandatory")
    private String skillsRequired;

    @NotNull(message = "Budget is required")
    @Positive(message = "Budget must be positive")
    private Double budget;

    @NotBlank(message = "Duration is required")
    private String duration;

    @NotNull(message = "Recruiter ID is required")
    private Long recruiterId;
}
