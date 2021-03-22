package com.example.exam.service;

import com.example.exam.model.service.AlbumServiceModel;
import com.example.exam.model.view.AlbumViewModel;

import java.util.List;

public interface AlbumService {


    AlbumServiceModel findByAlbumName(String name);

    void addAlbum(AlbumServiceModel albumServiceModel);

    List<AlbumViewModel> getAllAlbums();

    void deleteAlbum(String id);

    long getTotalCopies();
}
