package com.prunny.api.respository;

import com.prunny.api.entity.Genres;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GenresRepository extends JpaRepository<Genres, Long> {
   Optional<Genres> findByGenreTitle(String genreTitle);
}
