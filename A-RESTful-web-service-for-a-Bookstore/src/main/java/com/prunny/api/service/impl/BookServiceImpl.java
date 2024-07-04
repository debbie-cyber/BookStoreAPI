package com.prunny.api.service.impl;

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
import com.prunny.api.respository.AuthorsRepository;
import com.prunny.api.respository.BooksRepository;
import com.prunny.api.respository.GenresRepository;
import com.prunny.api.service.BookStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookStoreService {
    private final BooksRepository booksRepository;
    private final AuthorsRepository authorsRepository;
    private final GenresRepository genresRepository;

    @Override
    public String createGenre(GenreCreationRequest request) throws BookStoreException {

        if (request.getGenreTitle().isEmpty()) {
            throw new BookStoreException("Genre Title is empty");
        }

        Optional<Genres> genres = genresRepository.findByGenreTitle(request.getGenreTitle());

        if (genres.isEmpty()) {
            Genres newGenre = new Genres();
            newGenre.setGenreTitle(request.getGenreTitle());

            genresRepository.save(newGenre);
        } else {
            throw new BookStoreException("Genre already exist");
        }

        return "You have successfully created a new genre";
    }

    @Override
    public String createAuthor(AuthorCreationRequest request) throws BookStoreException {
        if (request.getFirstName().isEmpty()) {
            throw new BookStoreException("First Name is empty");
        }
        if (request.getLastName().isEmpty()) {
            throw new BookStoreException("Last Name is empty");
        }

        Optional<Authors> authors = authorsRepository.findByEmail(request.getEmail());

        if (authors.isEmpty()) {
            Authors newAuthors = new Authors();
            newAuthors.setFirstName(request.getFirstName());
            newAuthors.setLastName(request.getLastName());
            newAuthors.setEmail(request.getEmail());

            authorsRepository.save(newAuthors);
        } else {
            throw new BookStoreException("Author already exists");
        }

        return "You have successfully created a new author";
    }

    @Override
    public String createBook(BookCreationRequest request) throws BookStoreException {
        if (request.getAuthorsEmail().isEmpty()) {
            throw new BookStoreException("Authors Name is empty");
        }
        if (request.getGenre().isEmpty()) {
            throw new BookStoreException("Book Genre is empty");
        }
        if (request.getTitle().isEmpty()) {
            throw new BookStoreException("Book Title is empty");
        }

        Optional<Books> book = booksRepository.findByTitle(request.getTitle());
        if (book.isEmpty()){

        Genres genres = genresRepository.findByGenreTitle(request.getGenre())
                .orElseThrow(() -> new BookStoreException("Genre doesn't exist"));

        Books newBook = new Books();

        newBook.setTitle(request.getTitle());
        newBook.setGenre(genres);

        List<String> authorsList = request.getAuthorsEmail();
        Set<Authors> newAuthorsList = new HashSet<>();

        for (String author : authorsList) {
           Authors authors = authorsRepository.findByEmail(author)
                   .orElseThrow(() -> new BookStoreException("Author does not exist"));
           newAuthorsList.add(authors);
        }

        newBook.setAuthors(newAuthorsList);
        newBook.setPublicationDate(LocalDate.now());
        }
        return "You have successfully created a new book";
    }

    @Override
    public List<GenreResponse> getAllGenres() {
        List<Genres> genresList = genresRepository.findAll();

        List<GenreResponse> genreResponses = new ArrayList<>();

        for (Genres genre : genresList) {
            GenreResponse genreResponse = new GenreResponse();
            genreResponse.setId(genre.getId());
            genreResponse.setGenreTitle(genre.getGenreTitle());
            genreResponses.add(genreResponse);
        }
        return genreResponses;
    }

    @Override
    public List<BookResponse> getAllBooks() {
        List<Books> booksList = booksRepository.findAll();


        List<BookResponse> bookResponses = new ArrayList<>();

        for(Books book : booksList) {
            BookResponse bookResponse = new BookResponse();

            bookResponse.setId(book.getId());
            bookResponse.setTitle(book.getTitle());

            Set<Authors> authorsBookList = book.getAuthors();
            Set<AuthorResponse> authorsBookResponse = new HashSet<>();

            for (Authors author : authorsBookList) {
                AuthorResponse authorResponse = new AuthorResponse();
                authorResponse.setId(author.getId());
                authorResponse.setFirstName(author.getFirstName());
                authorResponse.setLastName(author.getLastName());
                authorResponse.setEmail((author.getEmail()));
                authorsBookResponse.add(authorResponse);
            }

            bookResponse.setAuthors(authorsBookResponse);

            GenreResponse genreResponse = new GenreResponse();
            genreResponse.setId(genreResponse.getId());
            genreResponse.setGenreTitle(genreResponse.getGenreTitle());

            bookResponse.setGenre(genreResponse);

            bookResponses.add(bookResponse);
        }
        return bookResponses;
    }

    @Override
    public List<AuthorResponse> getAllAuthors() {
        List<Authors> authorsList = authorsRepository.findAll();

        List<AuthorResponse> authorResponses = new ArrayList<>();

        for (Authors authors : authorsList) {
            AuthorResponse authorResponse = new AuthorResponse();
            authorResponse.setId(authors.getId());
            authorResponse.setFirstName(authors.getFirstName());
            authorResponse.setLastName(authors.getLastName());
            authorResponse.setEmail(authors.getEmail());
            authorResponses.add(authorResponse);
        }
        return authorResponses;
    }
}
