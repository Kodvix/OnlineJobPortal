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
public class JobSeeker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long jobSeekerId;
    @NotNull(message = "First name is required")
    private String firstName;
    @NotNull(message = "Last name is required")
    private String lastName;
    @NotNull(message = "Email is required")
    private String email;
    @NotNull(message = "Phone no. is required")
    private String phoneNo;
    @NotNull(message = "Resume is required")
    private String uploadResume;
    @NotNull(message = "Date of birth is required")
    private String dateOfBirth;
    private String skills;
    private String education;
    private String experience;
    private String address;

    @NotNull(message = "User cannot be null")
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}