package com.example.exam.repository;

import com.example.exam.model.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlbumRepository extends JpaRepository<Album, String> {

    Optional<Album> findByName(String name);

    List<Album> getAllByOrderByCopiesDesc();

    @Query("SELECT SUM(a.copies) FROM Album a")
    long getTotalCopies();
}
