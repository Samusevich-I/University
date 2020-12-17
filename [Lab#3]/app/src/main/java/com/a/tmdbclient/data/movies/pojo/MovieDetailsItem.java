package com.a.tmdbclient.data.movies.pojo;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MovieDetailsItem {

    private Integer id;

    private Boolean adult;

    private String backdropPath;

    private Integer budget;

    @PrimaryKey
    @NonNull
    private String imdbId;

    private String originalLanguage;

    private String originalTitle;

    private String overview;

    private Double popularity;

    private String posterPath;

    private String releaseDate;

    private Integer revenue;

    private Integer runtime;

    private String status;

    private String tagline;

    private String title;

    private Boolean video;

    private Double voteAverage;

    private Integer voteCount;

    public MovieDetailsItem() {
    }

    public MovieDetailsItem(Boolean adult, String backdropPath, Object belongsToCollection,
                            Integer budget, Object homepage, Integer id, String imdbId,
                            String originalLanguage, String originalTitle, String overview,
                            Double popularity, String posterPath, String releaseDate, Integer revenue,
                            Integer runtime, String status, String tagline, String title,
                            Boolean video, Double voteAverage, Integer voteCount) {
        super();
        this.adult = adult;
        this.backdropPath = backdropPath;
        this.budget = budget;
        this.id = id;
        this.imdbId = imdbId;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.overview = overview;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.releaseDate = releaseDate;
        this.revenue = revenue;
        this.runtime = runtime;
        this.status = status;
        this.tagline = tagline;
        this.title = title;
        this.video = video;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
    }

    public Boolean getAdult() {
        return adult;
    }

    public String getBackdropPath() {
        return backdropPath;
    }


    public Integer getBudget() {
        return budget;
    }


    public Integer getId() {
        return id;
    }

    public String getImdbId() {
        return imdbId;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public Double getPopularity() {
        return popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public Integer getRevenue() {
        return revenue;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public String getStatus() {
        return status;
    }

    public String getTagline() {
        return tagline;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getVideo() {
        return video;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }



    public void setBudget(Integer budget) {
        this.budget = budget;
    }


    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setRevenue(Integer revenue) {
        this.revenue = revenue;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }
}