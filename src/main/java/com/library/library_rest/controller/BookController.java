package com.library.library_rest.controller;


import com.library.library_rest.model.Book;
import com.library.library_rest.service.IBookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/books")
@RestController
@AllArgsConstructor
@Tag(name = "Book")
public class BookController {

    private final IBookService bookService;

    @Operation(summary = "Retrieve all books", description = "Endpoint for fetching all books",
            responses = {
                    @ApiResponse(description = "Successful retrieval of all books", responseCode = "200"),
                    @ApiResponse(description = "Unauthorized access", responseCode = "403"),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500")
            })
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @Operation(summary = "Create a new book", description = "Endpoint for creating a new book",
            responses = {
                    @ApiResponse(description = "Book created successfully", responseCode = "201"),
                    @ApiResponse(description = "Bad Request", responseCode = "400"),
                    @ApiResponse(description = "Unauthorized access", responseCode = "403"),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500")
            })
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @Operation(summary = "Retrieve a book by ID", description = "Endpoint for fetching a book by its ID",
            responses = {
                    @ApiResponse(description = "Successful retrieval of book", responseCode = "200"),
                    @ApiResponse(description = "Book not found", responseCode = "404"),
                    @ApiResponse(description = "Unauthorized access", responseCode = "403"),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500")
            })
    @GetMapping("{id}")
    public Book getBook(@PathVariable("id") long id) {
        return bookService.getBookById(id);
    }

    @Operation(summary = "Update an existing book", description = "Endpoint for updating an existing book",
            responses = {
                    @ApiResponse(description = "Book updated successfully", responseCode = "200"),
                    @ApiResponse(description = "Validation error", responseCode = "400"),
                    @ApiResponse(description = "Book not found", responseCode = "404"),
                    @ApiResponse(description = "Unauthorized access", responseCode = "403"),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500")
            })
    @PutMapping
    public Book updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @Operation(summary = "Delete a book by ID", description = "Endpoint for deleting a book by its ID",
            responses = {
                    @ApiResponse(description = "Book deleted successfully", responseCode = "200"),
                    @ApiResponse(description = "Bad Request", responseCode = "400"),
                    @ApiResponse(description = "Unauthorized access", responseCode = "403"),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500")
            })
    @DeleteMapping("{id}")
    public void deleteBook(@PathVariable long id) {
        bookService.deleteBook(id);
    }

}
