package com.MiniLibraryManagementSystem.MiniLibraryManagementSystem.repository;

import com.MiniLibraryManagementSystem.MiniLibraryManagementSystem.data.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
