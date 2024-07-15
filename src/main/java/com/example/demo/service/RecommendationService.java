package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Video;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class RecommendationService {

    private static final double WEIGHT_RATINGS = 0.60;
    private static final double WEIGHT_VIEWS = 0.40;

    public List<Video> rankVideos(List<Video> videos) {
        calculateScores(videos);

        Collections.sort(videos, Comparator.comparingDouble(Video::getScore).reversed());
        // Sort videos according to score and return the sorted list
        return videos;
    }

    private void calculateScores(List<Video> videos) {
        double maxUserRatings = videos.stream().mapToDouble(Video::getRatings).max().orElse(1);
        int maxViews = videos.stream().mapToInt(Video::getViews).max().orElse(1);

        for (Video video : videos) {
            double normalisedRatings = video.getRatings() / maxUserRatings;
            double normalisedViews = (double) video.getViews() / maxViews;
            
            double compositeScore = WEIGHT_RATINGS * normalisedRatings +
                    WEIGHT_VIEWS * normalisedViews;

            video.setScore(compositeScore);
        }
    }
}
