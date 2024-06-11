package com.library.library_rest.DAO.impl;

import com.library.library_rest.DAO.IBookDAO;
import com.library.library_rest.model.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class BookDAOImpl implements IBookDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Book> getAllBooks() {
        return entityManager.createQuery("from Book", Book.class).getResultList();
    }

    @Override
    public Book saveBook(Book book) {
        entityManager.persist(book);
        return book;
    }

    @Override
    public Book updateBook(Book book) {
        return entityManager.merge(book);
    }

    @Override
    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public void deleteBook(long id) {
        Book book = findById(id);
        if (book != null) {
            entityManager.remove(book);
        }
    }
}
