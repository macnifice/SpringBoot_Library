package com.library.library_rest;

import com.library.library_rest.model.Book;
import com.library.library_rest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }
    public Book getBookById(long id) {
        return bookRepository
                .findById(id)
                .orElse(null);
    }
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }
    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }




}
