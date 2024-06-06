package com.library.library_rest;

import com.library.library_rest.model.Book;
import com.library.library_rest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
        Optional<Book> book = bookRepository.findById(id);
        return book.get();
    }
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }
    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }




}
