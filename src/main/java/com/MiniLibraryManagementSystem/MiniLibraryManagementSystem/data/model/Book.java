package com.MiniLibraryManagementSystem.MiniLibraryManagementSystem.data.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@Table(name = "Book")
@ToString
@RequiredArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "This field cannot be null")
    @NotBlank(message = "This field is required")
    private String title;

    @NotNull(message = "This field cannot be null")
    @NotBlank(message = "This field is required")
    private String author;

    @NotNull(message = "This field cannot be null")
    @NotBlank(message = "This field is required")
    private int publicationYear;

    @Pattern(regexp = "[A-Z]{3}-[0-9]{3}")
    private int isbn;

    public Book(String title, String author, int publicationYear, int isbn){
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
    }
}
