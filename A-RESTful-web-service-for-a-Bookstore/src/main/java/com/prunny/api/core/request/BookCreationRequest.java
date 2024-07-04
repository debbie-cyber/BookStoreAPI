package com.prunny.api.core.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@ToString
public class BookCreationRequest {

    private String title;

    private List<String> authorsEmail;

    private String genre;

    private LocalDate publicationDate;
}
