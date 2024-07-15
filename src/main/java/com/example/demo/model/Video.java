package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

public class Video {

    public Video(int id, double ratings, int views) {
        this.id = id;
        this.ratings = ratings;
        this.views = views;
    }

    @Getter @Setter
    public int id;

    @Getter @Setter
    public double ratings;

    @Getter @Setter
    public int views;

    @Getter @Setter
    public double score;
}