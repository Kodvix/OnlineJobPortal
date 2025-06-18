package com.kodvix.OnlineJobPortal.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
public class Freelancer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long freelancerId;
    @NotNull(message = "Resume cannot be null")
    private String uploadResume;
    @NotNull(message = "Skills cannot be null")
    private String skills;
    private String preferedDomain;
    private String expectedHourlyPayRate;
    @NotNull(message = "ProfileSummary cannot be null")
    private String profileSummary;
    private String portfolioLink;
    @NotNull(message = "Education cannot be null")
    private String education;
    @NotNull(message = "Experience cannot be null")
    private String experience;

    @NotNull(message = "User cannot be null")
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
