package com.kodvix.OnlineJobPortal.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class AdminDto {

    @NotNull(message = "Name is required")
    private String name;
    @NotNull(message = "Email is required")
    private String email;
    @NotNull(message = "ContactNo is required")
    private String contactNumber;

    @NotNull(message = "UserId is required")
    private Long userId;
}
