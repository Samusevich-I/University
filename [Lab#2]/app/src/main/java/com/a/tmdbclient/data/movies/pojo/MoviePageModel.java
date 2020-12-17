package com.a.tmdbclient.data.movies.pojo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class MoviePageModel implements Serializable {

    @SerializedName("page")
    private int page;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("total_pages")
    private int totalPages;
    @SerializedName("results")
    private ArrayList<MovieModel> movieModel;

    public MoviePageModel(int page, int totalResults, int totalPages, ArrayList<MovieModel> movieModel) {
        this.page = page;
        this.totalResults = totalResults;
        this.totalPages = totalPages;
        this.movieModel = movieModel;
    }

    public int getPage() {
        return page;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public ArrayList<MovieModel> getMoviesList() {
        return movieModel;
    }

}

