package com.kodvix.OnlineJobPortal.entity;

import com.kodvix.OnlineJobPortal.enums.Role;
import jakarta.persistence.*;
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
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;
    private String country;
    private String state;
    private String city;
    private boolean isVerified; //user identity verified or not
    private Date createdAt;

//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//    private Freelancer freelancer;
//
//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//    private JobSeeker jobSeeker;


    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Recruiter recruiter;
}