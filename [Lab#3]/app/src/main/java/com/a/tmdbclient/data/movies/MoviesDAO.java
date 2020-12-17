package com.a.tmdbclient.data.movies;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.a.tmdbclient.data.movies.pojo.MovieDetails;
import com.a.tmdbclient.data.movies.pojo.MovieDetailsItem;

import java.util.List;

@Dao
public interface MoviesDAO {

    @Query("SELECT * FROM moviedetailsitem")
    List<MovieDetailsItem> getAll();

    @Query("SELECT * FROM moviedetailsitem WHERE id = :id")
    MovieDetailsItem getById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(MovieDetailsItem alarmItem);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(MovieDetailsItem alarmItem);

    @Delete
    void delete(MovieDetailsItem alarmItem);

}
