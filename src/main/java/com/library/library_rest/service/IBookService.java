package com.library.library_rest.service;
import com.library.library_rest.DTO.BookDTO;
import java.util.List;

public interface IBookService {

    List<BookDTO> getAllBooks();

    BookDTO createBook(BookDTO bookDTO);

    BookDTO getBookById(long id);

    BookDTO updateBook(BookDTO bookDTO);

    void deleteBook(long id);


}
