package com.MiniLibraryManagementSystem.MiniLibraryManagementSystem.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Borrowed_book")
@Setter
@Getter
@RequiredArgsConstructor
 public class BorrowedBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String bookName;
    private String bookAuthor;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book bookId;

    public BorrowedBook(String bookName, String bookAuthor){
       this.bookName = bookName;
       this.bookAuthor = bookAuthor;
    }
}
