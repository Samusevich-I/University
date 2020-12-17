package com.a.tmdbclient.data.movies;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.a.tmdbclient.data.movies.pojo.MovieDetails;
import com.a.tmdbclient.data.movies.pojo.MovieDetailsItem;

@Database(entities = {MovieDetailsItem.class}, version = 2, exportSchema = false)
    public abstract class MoviesDB extends RoomDatabase {
        private static MoviesDB INSTANCE;

        public static MoviesDB getDatabaseInstance(Context context) {
            if (INSTANCE == null) {
                INSTANCE =
                        Room.databaseBuilder(context.getApplicationContext(), MoviesDB.class, "MoviesDB")
                                .fallbackToDestructiveMigration()
                                .build();
            }
            return INSTANCE;
        }

        public abstract MoviesDAO moviesDAO();

        public static void destroyInstance() {
            INSTANCE = null;
        }
    }

