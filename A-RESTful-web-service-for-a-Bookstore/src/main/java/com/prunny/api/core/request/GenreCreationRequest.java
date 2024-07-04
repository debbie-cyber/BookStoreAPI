package com.prunny.api.core.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class GenreCreationRequest {
    private String genreTitle;
}
