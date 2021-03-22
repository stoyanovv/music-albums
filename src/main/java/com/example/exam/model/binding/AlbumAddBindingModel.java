package com.example.exam.model.binding;

import com.example.exam.model.entity.Artist;
import com.example.exam.model.entity.User;
import com.example.exam.model.entity.enums.Genre;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumAddBindingModel {

    private String name;
    private String imageUrl;
    private String description;
    private int copies;
    private BigDecimal price;
    private LocalDate releasedDate;
    private String producer;
    private Genre genre;
    private String artist;
    private User addedFrom;

    public AlbumAddBindingModel() {
    }

    @Size(min = 3, max = 20, message = "Album`s name must be between 3 and 20 characters")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Size(min = 3, message = "Image url must be at least 5 characters")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Size(min = 5, message = "Description must be at least 5 characters")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Min(value = 10, message = "Copies must be at least")
    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    @Min(value = 0, message = "Price must be a positive number")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @PastOrPresent(message = "The dade can not be in the future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "You must enter a date")
    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(LocalDate releasedDate) {
        this.releasedDate = releasedDate;
    }


    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @NotNull(message = "You must select a genre")
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @NotBlank(message = "You must select an artist")
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }



    public User getAddedFrom() {
        return addedFrom;
    }

    public void setAddedFrom(User addedFrom) {
        this.addedFrom = addedFrom;
    }
}
