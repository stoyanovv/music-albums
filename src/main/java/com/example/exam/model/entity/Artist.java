package com.example.exam.model.entity;

import com.example.exam.model.entity.enums.SingerName;
import com.fasterxml.jackson.databind.ser.Serializers;

import javax.persistence.*;

@Entity
@Table(name = "artists")
public class Artist extends BaseEntity{

    private SingerName singerName;
    private String careerInformation;

    public Artist() {
    }

    public Artist(SingerName singerName, String careerInformation) {
        this.singerName = singerName;
        this.careerInformation = careerInformation;
    }

    @Enumerated(EnumType.STRING)
    public SingerName getSingerName() {
        return singerName;
    }

    public void setSingerName(SingerName singerName) {
        this.singerName = singerName;
    }

    @Column(columnDefinition = "TEXT", name = "career_information")
    public String getCareerInformation() {
        return careerInformation;
    }

    public void setCareerInformation(String careerInformation) {
        this.careerInformation = careerInformation;
    }
}
