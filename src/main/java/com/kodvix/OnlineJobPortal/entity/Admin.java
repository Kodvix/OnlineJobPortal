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
public class Admin {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long adminId;
        @NotNull(message = "Name cannot be null")
        private String name;
        @NotNull(message = "Email cannot be null")
        private String email;
        @NotNull(message = "ContactNumber cannot be null")
        private String contactNumber;

        @NotNull(message = "User cannot be null")
        @OneToOne
        @JoinColumn(name = "user_id", nullable = false)
        private User user;
}
