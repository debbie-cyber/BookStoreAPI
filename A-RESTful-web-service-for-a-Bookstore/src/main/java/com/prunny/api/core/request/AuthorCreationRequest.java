package com.prunny.api.core.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AuthorCreationRequest {
    private String firstName;

    private String lastName;

    private String email;
}
