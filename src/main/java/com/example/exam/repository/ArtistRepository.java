package com.example.exam.repository;

import com.example.exam.model.entity.Artist;
import com.example.exam.model.entity.enums.SingerName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, String> {

    Artist getBySingerName(SingerName name);
}
