package com.example.exam.service;

import com.example.exam.model.entity.Artist;

public interface ArtistService {

    void initArtists();

    Artist findByName(String artist);
}
