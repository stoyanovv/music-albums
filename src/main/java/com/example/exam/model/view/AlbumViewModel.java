package com.example.exam.model.view;

import com.example.exam.model.entity.Artist;
import com.example.exam.model.entity.User;
import com.example.exam.model.entity.enums.Genre;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumViewModel {

    private String id;
    private String name;
    private String imageUrl;
    private int copies;
    private BigDecimal price;
    private LocalDate releasedDate;
    private Genre genre;
    private Artist artist;
    private User addedFrom;

    public AlbumViewModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(LocalDate releasedDate) {
        this.releasedDate = releasedDate;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public User getAddedFrom() {
        return addedFrom;
    }

    public void setAddedFrom(User addedFrom) {
        this.addedFrom = addedFrom;
    }
}
