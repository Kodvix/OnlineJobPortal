    package com.kodvix.OnlineJobPortal.dto;

    import lombok.*;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class JobResponseDto {
        private Long id;
        private String title;
        private String description;
        private String location;
        private String jobType;
        private Double salary;
        private String experienceLevel;
        private String recruiterName;
        private String recruiterCompany;
    }
