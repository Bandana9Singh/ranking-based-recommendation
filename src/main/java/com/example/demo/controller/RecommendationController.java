package com.example.demo.controller;

import com.example.demo.model.Video;
import com.example.demo.service.RecommendationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080") // Adjust the origin as needed
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    @GetMapping("/recommendations")
    public List<Video> getRecommendations() {
        List<Video> recommendedVideos = getRecommendedVideos();
        return recommendationService.rankVideos(recommendedVideos);
    }

    private List<Video> getRecommendedVideos() {
        List<Video> videos = new ArrayList<>();
        videos.add(new Video(1, 4.5, 1500));
        videos.add(new Video(2, 4.0, 1200));
        videos.add(new Video(3, 3.5, 3000));
        videos.add(new Video(4, 5.0, 500));
        videos.add(new Video(5, 4.2, 800));
        return videos;
    }
}
