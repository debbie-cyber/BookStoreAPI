package com.prunny.api.core.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AuthorResponse {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;
}
