package com.a.tmdbclient.data.shows.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ShowModel {

    @SerializedName("poster_path")
    @Expose
    private String posterPath;
    @SerializedName("popularity")
    @Expose
    private Double popularity;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("backdrop_path")
    @Expose
    private String backdropPath;
    @SerializedName("vote_average")
    @Expose
    private Double voteAverage;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("first_air_date")
    @Expose
    private String firstAirDate;
    @SerializedName("origin_country")
    @Expose
    private List<String> originCountry = null;
    @SerializedName("genre_ids")
    @Expose
    private List<Integer> genreIds = null;
    @SerializedName("original_language")
    @Expose
    private String originalLanguage;
    @SerializedName("vote_count")
    @Expose
    private Integer voteCount;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("original_name")
    @Expose
    private String originalName;

    public ShowModel() {
    }

    public ShowModel(String posterPath, Double popularity, Integer id, String backdropPath,
                     Double voteAverage, String overview, String firstAirDate,
                     List<String> originCountry, List<Integer> genreIds, String originalLanguage,
                     Integer voteCount, String name, String originalName) {
        super();
        this.posterPath = posterPath;
        this.popularity = popularity;
        this.id = id;
        this.backdropPath = backdropPath;
        this.voteAverage = voteAverage;
        this.overview = overview;
        this.firstAirDate = firstAirDate;
        this.originCountry = originCountry;
        this.genreIds = genreIds;
        this.originalLanguage = originalLanguage;
        this.voteCount = voteCount;
        this.name = name;
        this.originalName = originalName;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public Double getPopularity() {
        return popularity;
    }

    public Integer getId() {
        return id;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public String getOverview() {
        return overview;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public List<String> getOriginCountry() {
        return originCountry;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public String getName() {
        return name;
    }

    public String getOriginalName() {
        return originalName;
    }

}