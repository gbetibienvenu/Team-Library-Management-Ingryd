package com.MiniLibraryManagementSystem.MiniLibraryManagementSystem.service;

import com.MiniLibraryManagementSystem.MiniLibraryManagementSystem.data.model.Book;
import com.MiniLibraryManagementSystem.MiniLibraryManagementSystem.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void addABook(Book book){
        bookRepository.save(book);
    }

    public void deleteABook(@PathVariable int id){
        bookRepository.deleteById(id);
    }

    public Book getABook(@PathVariable int id){
        if (isAvailable(id)) {
            return bookRepository.findById(id).orElseThrow();
        }
        return null;
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll().stream().toList();
    }

    public boolean isAvailable(@PathVariable int id){
        return bookRepository.existsById(id);
    }
}
