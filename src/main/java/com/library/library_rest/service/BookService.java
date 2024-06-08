package com.library.library_rest.service;
import com.library.library_rest.model.Book;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface BookService {

    List<Book> getAllBooks();

    Book createBook(Book book);

    Book getBookById(long id);

    Book updateBook(Book book);

    void deleteBook(long id);


}
