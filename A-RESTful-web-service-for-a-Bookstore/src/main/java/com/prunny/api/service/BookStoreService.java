package com.prunny.api.service;

import com.prunny.api.core.exception.BookStoreException;
import com.prunny.api.core.request.AuthorCreationRequest;
import com.prunny.api.core.request.BookCreationRequest;
import com.prunny.api.core.request.GenreCreationRequest;
import com.prunny.api.core.response.AuthorResponse;
import com.prunny.api.core.response.BookResponse;
import com.prunny.api.core.response.GenreResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookStoreService {

     String createGenre(GenreCreationRequest request) throws BookStoreException;

     String createAuthor(AuthorCreationRequest request) throws BookStoreException;

     String createBook(BookCreationRequest request) throws BookStoreException;

     List<GenreResponse> getAllGenres();

     List<BookResponse> getAllBooks();

     List<AuthorResponse> getAllAuthors();
}
