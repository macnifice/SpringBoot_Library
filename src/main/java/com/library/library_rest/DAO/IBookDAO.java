package com.library.library_rest.DAO;

import com.library.library_rest.model.Book;

import java.util.List;

public interface IBookDAO {
    List<Book> getAllBooks();

    Book saveBook(Book book);

    Book updateBook(Book book);

    Book findById(long id);

    void deleteBook(long id);

}
