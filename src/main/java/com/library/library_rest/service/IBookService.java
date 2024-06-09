package com.library.library_rest.service;
import com.library.library_rest.model.Book;
import java.util.List;

public interface IBookService {

    List<Book> getAllBooks();

    Book createBook(Book book);

    Book getBookById(long id);

    Book updateBook(Book book);

    void deleteBook(long id);


}
