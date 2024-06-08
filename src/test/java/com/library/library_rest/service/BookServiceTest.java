package com.library.library_rest.service;

import com.library.library_rest.model.Book;
import com.library.library_rest.repository.BookRepository;
import com.library.library_rest.service.impl.BookServiceImpl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    private Book book;
    private Book book2;

    @BeforeEach
    public void setUp() {
        book = Book.builder()
                .id(1L)
                .title("Book Title")
                .author("Author")
                .isbn("Isbn").build();

        book2 = Book.builder()
                .id(2L)
                .title("Book Title 2")
                .author("Author 2")
                .isbn("Isbn 2").build();
    }

    @Test
    void testFindAll() {
        given(bookRepository.findAll()).willReturn(List.of(book, book2));

        List<Book> books = bookService.getAllBooks();


        Assertions.assertThat(books).isNotNull();
        Assertions.assertThat(books).hasSize(2);
    }

    @Test
    void testSaveBook() {
        when(bookRepository.save(book)).thenReturn(book);

        Book savedBook = bookService.createBook(book);

        Assertions.assertThat(savedBook).isNotNull();
    }

    @Test
    void testUpdateBook() {
        when(bookRepository.save(book)).thenReturn(book);
        book.setTitle("Test Tittle");
        book.setAuthor("Test Author");
        book.setIsbn("Test Isbn");

        Book savedBook = bookService.updateBook(book);

        Assertions.assertThat(savedBook.getTitle()).isEqualTo("Test Tittle");
        Assertions.assertThat(savedBook.getAuthor()).isEqualTo("Test Author");
        Assertions.assertThat(savedBook.getIsbn()).isEqualTo("Test Isbn");

    }

    @Test
    void testFindById() {
        when(bookRepository.findById(1L)).thenReturn(Optional.ofNullable(book));

        Book bookById = bookService.getBookById(book.getId());

        Assertions.assertThat(bookById).isNotNull();

    }

    @Test
    void testDeleteBook() {
        long bookId = 1L;
        willDoNothing().given(bookRepository).deleteById(bookId);

        bookService.deleteBook(bookId);

        verify(bookRepository,times(1)).deleteById(bookId);

    }

}
