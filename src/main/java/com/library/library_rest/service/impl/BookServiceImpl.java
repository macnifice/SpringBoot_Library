package com.library.library_rest.service.impl;

import com.library.library_rest.DAO.IBookDAO;
import com.library.library_rest.DTO.BookDTO;
import com.library.library_rest.model.Book;

import com.library.library_rest.service.IBookService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BookServiceImpl implements IBookService {

    private final IBookDAO iBookDAO;
    private final ModelMapper modelMapper;

    @Override
    public List<BookDTO> getAllBooks() {
        return iBookDAO.getAllBooks()
                .stream()
                .map(book -> modelMapper.map(book, BookDTO.class))
                .collect(Collectors.toList());

    }

    @Override
    public BookDTO createBook(BookDTO bookDTO) {
        Book book = modelMapper.map(bookDTO, Book.class);
        Book savedBok = iBookDAO.saveBook(book);
        return modelMapper.map(savedBok, BookDTO.class);
    }

    @Override
    public BookDTO getBookById(long id) {
        Book book = iBookDAO.findById(id);
        return modelMapper.map(book, BookDTO.class);
    }

    @Override
    public BookDTO updateBook(BookDTO bookDTO) {
        Book book = modelMapper.map(bookDTO, Book.class);
        Book updatedBook = iBookDAO.updateBook(book);
        return modelMapper.map(updatedBook, BookDTO.class);
    }

    @Override
    public void deleteBook(long id) {
        iBookDAO.deleteBook(id);
    }
}
