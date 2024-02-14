package com.MiniLibraryManagementSystem.MiniLibraryManagementSystem.controller;

import com.MiniLibraryManagementSystem.MiniLibraryManagementSystem.data.model.Book;
import com.MiniLibraryManagementSystem.MiniLibraryManagementSystem.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    // Endpoint to get all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Endpoint to get a book by ID
    @GetMapping
    public Book  getBookById(@PathVariable Long id) {
        return bookRepository.findById(Math.toIntExact(id)).orElse(null);
    }

    // Endpoint to add a new book
    @PostMapping
    public Book addBook(@RequestBody Book book){
        return  bookRepository.save(book);
    }

    // Endpoint to update a book
    @PutMapping("/{id}")
    public  Book updatedBook(@PathVariable long id, @RequestBody Book updatedBook ){
        Book existingBook = bookRepository.findById((int) id).orElse(null);
        if (existingBook != null){
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            return  bookRepository.save(existingBook);
        }
        return null;
    }
    // Endpoint to delete a book by ID
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable long id){
        bookRepository.deleteById((int) id);
    }
}
