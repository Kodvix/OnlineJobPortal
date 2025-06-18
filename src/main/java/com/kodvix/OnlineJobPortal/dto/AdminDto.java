package com.kodvix.OnlineJobPortal.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class AdminDto {

    @NotNull(message = "Name cannot be null")
    private String name;
    @NotNull(message = "Email cannot be null")
    private String email;
    @NotNull(message = "contactNumber cannot be null")
    private String contactNumber;

    @NotNull(message = "UserId is required")
    private Long userId;
}
