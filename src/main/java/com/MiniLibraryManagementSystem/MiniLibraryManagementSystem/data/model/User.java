package com.MiniLibraryManagementSystem.MiniLibraryManagementSystem.data.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@Table(name = "User")
@ToString
public class User {

    @NotNull(message = "This field cannot be null")
    @NotBlank(message = "This field is required")
    @Email(message = "Kindly enter a valid email address")
    private String email;

    @NotNull
    @NotBlank(message = "This field is required")
    @Length(min = 6, max = 15, message = "Your full name cannot be less than 6 characters or more than 15 characters")
    @Column(name = "full_name")
    private String fullName;

    @NotNull
    @Min(value = 18, message = "You cannot be less than 18 years old")
    @Max(value = 70, message = "You cannot be older than 70 years old")
    int age;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public User(String email, String fullName, int age) {
    this.email = email;
    this.fullName = fullName;
    this.age = age;
    }
}
