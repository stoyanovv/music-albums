package com.example.exam.service.impl;

import com.example.exam.model.entity.Album;
import com.example.exam.model.service.AlbumServiceModel;
import com.example.exam.model.view.AlbumViewModel;
import com.example.exam.repository.AlbumRepository;
import com.example.exam.service.AlbumService;
import com.example.exam.service.ArtistService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;
    private final ModelMapper modelMapper;
    private final ArtistService artistService;

    public AlbumServiceImpl(AlbumRepository albumRepository, ModelMapper modelMapper, ArtistService artistService) {
        this.albumRepository = albumRepository;
        this.modelMapper = modelMapper;
        this.artistService = artistService;
    }

    @Override
    public AlbumServiceModel findByAlbumName(String name) {
        return this.albumRepository.findByName(name)
                .map(product -> modelMapper.map(product, AlbumServiceModel.class))
                .orElse(null);
    }

    @Override
    public void addAlbum(AlbumServiceModel albumServiceModel) {
        Album album = modelMapper.map(albumServiceModel, Album.class);
        album.setArtist(artistService.findByName(albumServiceModel.getArtist()));
        albumRepository.save(album);
    }

    @Override
    public List<AlbumViewModel> getAllAlbums() {
        return albumRepository.getAllByOrderByCopiesDesc()
                .stream()
                .map(album -> modelMapper.map(album, AlbumViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAlbum(String id) {
        albumRepository.deleteById(id);
    }

    @Override
    public long getTotalCopies() {
        if (albumRepository.count() == 0) {
            return 0;
        }
        return albumRepository.getTotalCopies();
    }
}
