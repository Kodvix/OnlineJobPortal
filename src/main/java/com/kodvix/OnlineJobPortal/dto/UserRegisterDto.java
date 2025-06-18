package com.kodvix.OnlineJobPortal.dto;

import com.kodvix.OnlineJobPortal.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRegisterDto {

    @NotBlank(message = "First name cannot be blank")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    private String lastName;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email cannot be blank")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    @NotBlank(message = "Confirm password cannot be blank")
    private String confirmPassword;

    @NotNull(message = "Date of birth cannot be null")
    private String dateOfBirth;

    @NotBlank(message = "Phone number cannot be blank")
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Phone number must be valid 10-digit Indian number")
    private String phoneNumber;

    @NotNull(message = "Role cannot be null")
    private Role role;

    @NotBlank(message = "Country cannot be blank")
    private String country;

    @NotBlank(message = "State cannot be blank")
    private String state;

    @NotBlank(message = "City cannot be blank")
    private String city;
}
