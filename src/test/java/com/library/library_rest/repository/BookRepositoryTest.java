package com.library.library_rest.repository;

import com.library.library_rest.model.Book;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;


@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private IBookRepository ibookRepository;
    private Book book;

    @BeforeEach
    public void setUp() {
        book = Book.builder()
                .title("Book Title")
                .author("Author")
                .isbn("Isbn").build();
    }

    @Test
    void testFindAll() {
        //Given
        ibookRepository.save(book);
        //When
        List<Book> books = ibookRepository.findAll();

        //Then
        Assertions.assertThat(books).isNotNull();
        Assertions.assertThat(books.size()).isGreaterThan(0);

    }

    @Test
    void testSaveBook() {
        //Given
//        Book book = Book.builder()
//                .title("Book Title")
//                .author("Author Title")
//                .isbn("isbn")
//                .build();
        //When
        Book saveBook = ibookRepository.save(book);

        //Then
        Assertions.assertThat(saveBook).isNotNull();
        Assertions.assertThat(saveBook.getId()).isGreaterThan(0);

    }

    @Test
    void testUpdateBook() {
        //Given
        ibookRepository.save(book);

        //When
        book.setTitle("Title 1");
        book.setAuthor("Author 1");
        book.setIsbn("Isbn 1");
        Book updateBook = ibookRepository.save(book);

        Assertions.assertThat(updateBook.getTitle()).isEqualTo("Title 1");
        Assertions.assertThat(updateBook.getAuthor()).isEqualTo("Author 1");
        Assertions.assertThat(updateBook.getIsbn()).isEqualTo("Isbn 1");


    }

    @Test
    void testFindById() {
        //Given
        ibookRepository.save(book);
        //When
        Book getBook = ibookRepository.findById(book.getId()).get();

        //Then
        Assertions.assertThat(getBook).isNotNull();
    }

    @Test
    void testDeleteBook() {
        //Given
        ibookRepository.save(book);

        //When
        ibookRepository.deleteById(book.getId());
        Optional<Book> bookOptional = ibookRepository.findById(book.getId());
        //Then
        Assertions.assertThat(bookOptional).isEmpty();
    }
}
