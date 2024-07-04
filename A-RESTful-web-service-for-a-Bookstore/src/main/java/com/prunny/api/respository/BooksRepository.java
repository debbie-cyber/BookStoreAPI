package com.prunny.api.respository;

import com.prunny.api.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BooksRepository extends JpaRepository<Books, Long> {
    Optional<Books> findByTitle(String title);
}
