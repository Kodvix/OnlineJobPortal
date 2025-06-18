package com.kodvix.OnlineJobPortal.entity;

import com.kodvix.OnlineJobPortal.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "FirstName cannot be null")
    private String firstName;
    @NotNull(message = "LastName cannot be null")
    private String lastName;
    @NotNull(message = "Email cannot be null")
    private String email;
    @NotNull(message = "Password cannot be null")
    private String password;
    @NotNull(message = "ConfirmPassword cannot be null")
    private String confirmPassword;
    @NotNull(message = "DateOfBirth cannot be null")
    private String dateOfBirth;
    @NotNull(message = "PhoneNumber cannot be null")
    private String phoneNumber;
    @NotNull(message = "Role cannot be null")
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;
    @NotNull(message = "Country cannot be null")
    private String country;
    @NotNull(message = "State cannot be null")
    private String state;
    @NotNull(message = "City cannot be null")
    private String city;
    private boolean isVerified; //user identity verified or not
    private Date createdAt;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Freelancer freelancer;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private JobSeeker jobSeeker;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Admin admin;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Recruiter recruiter;
}