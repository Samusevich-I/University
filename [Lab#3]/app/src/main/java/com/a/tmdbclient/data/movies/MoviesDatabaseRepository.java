package com.a.tmdbclient.data.movies;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.a.tmdbclient.data.movies.pojo.MovieDetails;
import com.a.tmdbclient.data.movies.pojo.MovieDetailsItem;

import java.util.ArrayList;
import java.util.List;

public class MoviesDatabaseRepository {

    private MoviesDAO moviesDAO;
    private List<MovieDetailsItem> itemsList;

    public MoviesDatabaseRepository(Context context) {
        MoviesDB database = MoviesDB.getDatabaseInstance(context);
        this.moviesDAO = database.moviesDAO();
        itemsList = new ArrayList<>();
    }

    public List<MovieDetailsItem> getElementsList(LoadCallback callback) {
        loadData(callback);
        return itemsList;
    }

    public void insert(final MovieDetailsItem alarmItem) {
        new insertAsyncTask(moviesDAO).execute(alarmItem);
    }

    private static class insertAsyncTask extends AsyncTask<MovieDetailsItem, Void, Void> {
        private MoviesDAO alarmDao;

        private insertAsyncTask(MoviesDAO alarmDao) {
            this.alarmDao = alarmDao;
        }

        @Override
        protected Void doInBackground(MovieDetailsItem... alarmItems) {
            alarmDao.insert(alarmItems[0]);
            return null;
        }
    }

    public void delete(final MovieDetailsItem alarmItem) {
        new deleteAsyncTask(moviesDAO).execute(alarmItem);
    }

    private static class deleteAsyncTask extends AsyncTask<MovieDetailsItem, Void, Void> {
        private MoviesDAO alarmDao;

        private deleteAsyncTask(MoviesDAO alarmDao) {
            this.alarmDao = alarmDao;
        }

        @Override
        protected Void doInBackground(MovieDetailsItem... alarmItems) {
            alarmDao.delete(alarmItems[0]);
            return null;
        }
    }

    public void update(final MovieDetailsItem alarmItem) {
        new updateAsyncTask(moviesDAO).execute(alarmItem);
    }

    private static class updateAsyncTask extends AsyncTask<MovieDetailsItem, Void, Void> {
        private MoviesDAO alarmDao;

        private updateAsyncTask(MoviesDAO alarmDao) {
            this.alarmDao = alarmDao;
        }

        @Override
        protected Void doInBackground(MovieDetailsItem... alarmItems) {
            alarmDao.update(alarmItems[0]);
            return null;
        }
    }

    public interface LoadCallback {
        List<MovieDetailsItem> onLoadFinished(List<MovieDetailsItem> itemList);

        void onLoadFailed();
    }

    public void loadData(LoadCallback callback) {
        new ListLoader(moviesDAO, callback).execute();
    }

    public static class ListLoader extends AsyncTask {

        List<MovieDetailsItem> alarmItems;
        MoviesDAO alarmDao;
        LoadCallback callback;

        public ListLoader(MoviesDAO alarmDao, LoadCallback callback) {
            this.alarmDao = alarmDao;
            this.callback = callback;
        }

        @Override
        protected Object doInBackground(Object[] objects) {
            alarmItems = alarmDao.getAll();
            Log.d("list loader", "in back");
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            Log.d("list loader", "on post");
            callback.onLoadFinished(alarmItems);
            Log.d("list loader", alarmItems.toString());

        }

    }

}

