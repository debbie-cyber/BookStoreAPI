package com.prunny.api.respository;

import com.prunny.api.entity.Authors;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorsRepository extends JpaRepository<Authors, Long> {

    Optional<Authors> findByEmail(String email);
}
