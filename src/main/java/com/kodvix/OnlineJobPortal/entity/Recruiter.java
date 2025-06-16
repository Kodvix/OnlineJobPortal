package com.kodvix.OnlineJobPortal.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "recruiters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recruiter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Company name cannot be blank")
    @Column(nullable = false)
    private String companyName;

    @NotBlank(message = "Designation cannot be blank")
    @Column(nullable = false)
    private String designation;

    @NotBlank(message = "Company website cannot be blank")
    @Column(nullable = false)
    private String companyWebsite;

    @NotBlank(message = "Company address cannot be blank")
    @Column(nullable = false)
    private String companyAddress;

    @NotBlank(message = "Contact number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Contact number must be 10 digits")
    private String contactNumber;

    @NotBlank(message = "Company email is required")
    @Email(message = "Email should be valid")
    private String companyEmail;


    @NotNull(message = "User cannot be null")
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;





}
