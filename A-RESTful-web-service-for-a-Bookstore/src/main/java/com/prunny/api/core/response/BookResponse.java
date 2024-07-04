package com.prunny.api.core.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDate;
import java.util.Set;

@Setter
@Getter
@ToString
public class BookResponse {
    private Long id;

    private String title;

    private Set<AuthorResponse> authors;

    private GenreResponse genre;

    private LocalDate publicationDate;
}

