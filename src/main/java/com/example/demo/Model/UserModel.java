package com.example.demo.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKeyJoinColumn(name = "id")
    private Long id;

    @Column(nullable = false)
    @NotBlank
    @NotNull
    @NotEmpty
    private String username;

    @Column(nullable=false)
    @Email
    @NotBlank
    @NotNull
    @NotEmpty
    private String email;

    @Column(nullable=false)
    @NotBlank
    @NotNull
    @NotEmpty
    private String password;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;

}
