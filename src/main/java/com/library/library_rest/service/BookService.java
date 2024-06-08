package com.library.library_rest.service;
import com.library.library_rest.model.Book;
import com.library.library_rest.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

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
