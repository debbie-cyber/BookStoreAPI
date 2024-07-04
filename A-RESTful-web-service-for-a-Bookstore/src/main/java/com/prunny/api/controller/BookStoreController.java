package com.prunny.api.controller;

import com.prunny.api.core.exception.BookStoreException;
import com.prunny.api.core.request.AuthorCreationRequest;
import com.prunny.api.core.request.BookCreationRequest;
import com.prunny.api.core.request.GenreCreationRequest;
import com.prunny.api.core.response.AuthorResponse;
import com.prunny.api.core.response.BookResponse;
import com.prunny.api.core.response.GenreResponse;
import com.prunny.api.entity.Authors;
import com.prunny.api.entity.Books;
import com.prunny.api.entity.Genres;
import com.prunny.api.service.BookStoreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/book-store/api")

public class BookStoreController {
    private final BookStoreService bookStoreService;

    public BookStoreController(BookStoreService bookStoreService) {

        this.bookStoreService = bookStoreService;
    }

    @GetMapping("/home")
    public String home() {
        return "Welcome to The Bookstore API \n" +
                "A RESTful Web Service for a Bookstore";
    }

    @PostMapping("/genre/create")
    public String createGenre(GenreCreationRequest request) throws BookStoreException {
        return bookStoreService.createGenre(request);
    }

    @PostMapping("/author/create")
    public String createAuthor(AuthorCreationRequest request) throws BookStoreException {
        return bookStoreService.createAuthor(request);
    }

    @PostMapping("/book/create")
    public String createBook(BookCreationRequest request) throws BookStoreException {
        return bookStoreService.createBook(request);
    }

    @GetMapping("/genre/all")
    public List<GenreResponse> getAllGenres() {
        return bookStoreService.getAllGenres();
    }

    @GetMapping("/book/all")
    public List<BookResponse> getAllBooks() {
        return bookStoreService.getAllBooks();
    }

    @GetMapping("/author/all")
    public List<AuthorResponse> getAllAuthors() {
        return bookStoreService.getAllAuthors();
    }
}
