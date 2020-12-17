package com.a.tmdbclient.data.movies;

import com.a.tmdbclient.data.movies.pojo.MovieDetails;
import com.a.tmdbclient.data.movies.pojo.MoviePageModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MoviesApi {

    @GET("movie/popular")
    Call<MoviePageModel> getPopularMovies(@Query("page") int page, @Query("api_key") String userKey);

    @GET("movie/top_rated")
    Call<MoviePageModel> getTopRatedMovies(@Query("page") int page, @Query("api_key") String userKey);

    @GET("movie/upcoming")
    Call<MoviePageModel> getUpcomingMovies(@Query("page") int page, @Query("api_key") String userKey);

    @GET("movie/now_playing")
    Call<MoviePageModel> getNowPlayingMovies(@Query("page") int page, @Query("api_key") String userKey);

    @GET("movie/{movie_id}")
    Call<MovieDetails> getMovieDetails(@Path("movie_id") int id, @Query("api_key") String userKey);

    @GET("search/movie")
    Call<MoviePageModel> searchMovies(@Query("query") String query, @Query("page") int page, @Query("api_key") String userKey);

}
