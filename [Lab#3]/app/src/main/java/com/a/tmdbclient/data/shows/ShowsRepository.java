package com.a.tmdbclient.data.shows;

import android.os.AsyncTask;

import androidx.annotation.NonNull;

import com.a.tmdbclient.App;
import com.a.tmdbclient.data.NetworkUtils;
import com.a.tmdbclient.data.shows.pojo.ShowDetails;
import com.a.tmdbclient.data.shows.pojo.ShowPageModel;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowsRepository {

    @Inject
    ShowsApi api;

    public ShowsRepository() {
        App.getAppComponent().inject(this);
    }

    public void getPopularShows(int page, NetworkUtils.ShowLoadCallback callback) {
        new PopularShowTask(page, callback).execute();
    }

    private class PopularShowTask extends AsyncTask<Void, Void, Void> {

        private int mPage;
        private NetworkUtils.ShowLoadCallback mCallback;

        PopularShowTask(int page, NetworkUtils.ShowLoadCallback callback) {
            mPage = page;
            mCallback = callback;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            api.getPopularShows(mPage, NetworkUtils.API_KEY).enqueue(new Callback<ShowPageModel>() {
                @Override
                public void onResponse(@NonNull Call<ShowPageModel> call, @NonNull Response<ShowPageModel> response) {
                    mCallback.onLoadSuccess(response, response.body().getShowModels());
                }

                @Override
                public void onFailure(@NonNull Call<ShowPageModel> call, @NonNull Throwable t) {
                    mCallback.onLoadFail(call);
                }
            });
            return null;
        }
    }

    public void getTopRatedShows(int page, NetworkUtils.ShowLoadCallback callback) {
        new TopRatedShowTask(page, callback).execute();
    }

    private class TopRatedShowTask extends AsyncTask<Void, Void, Void> {

        private int mPage;
        private NetworkUtils.ShowLoadCallback mCallback;

        TopRatedShowTask(int page, NetworkUtils.ShowLoadCallback callback) {
            mPage = page;
            mCallback = callback;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            api.getTopRatedShows(mPage, NetworkUtils.API_KEY).enqueue(new Callback<ShowPageModel>() {
                @Override
                public void onResponse(@NonNull Call<ShowPageModel> call, @NonNull Response<ShowPageModel> response) {
                    mCallback.onLoadSuccess(response, response.body().getShowModels());
                }

                @Override
                public void onFailure(@NonNull Call<ShowPageModel> call, @NonNull Throwable t) {
                    mCallback.onLoadFail(call);
                }
            });
            return null;
        }
    }

    public void getUpcomingShows(int page, NetworkUtils.ShowLoadCallback callback) {
        new UpcomingShowTask(page, callback).execute();
    }

    private class UpcomingShowTask extends AsyncTask<Void, Void, Void> {

        private int mPage;
        private NetworkUtils.ShowLoadCallback mCallback;

        UpcomingShowTask(int page, NetworkUtils.ShowLoadCallback callback) {
            mPage = page;
            mCallback = callback;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            api.getUpcomingShows(mPage, NetworkUtils.API_KEY).enqueue(new Callback<ShowPageModel>() {
                @Override
                public void onResponse(@NonNull Call<ShowPageModel> call, @NonNull Response<ShowPageModel> response) {
                    mCallback.onLoadSuccess(response, response.body().getShowModels());
                }

                @Override
                public void onFailure(@NonNull Call<ShowPageModel> call, @NonNull Throwable t) {
                    mCallback.onLoadFail(call);
                }
            });
            return null;
        }
    }

    public void getNowPlayingShows(int page, NetworkUtils.ShowLoadCallback callback) {
        new NowPlayingShowTask(page, callback).execute();
    }

    private class NowPlayingShowTask extends AsyncTask<Void, Void, Void> {

        private int mPage;
        private NetworkUtils.ShowLoadCallback mCallback;

        NowPlayingShowTask(int page, NetworkUtils.ShowLoadCallback callback) {
            mPage = page;
            mCallback = callback;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            api.getNowPlayingShows(mPage, NetworkUtils.API_KEY).enqueue(new Callback<ShowPageModel>() {
                @Override
                public void onResponse(@NonNull Call<ShowPageModel> call, @NonNull Response<ShowPageModel> response) {
                    mCallback.onLoadSuccess(response, response.body().getShowModels());
                }

                @Override
                public void onFailure(@NonNull Call<ShowPageModel> call, @NonNull Throwable t) {
                    mCallback.onLoadFail(call);
                }
            });
            return null;
        }
    }

    public void getShowDetails(int page, NetworkUtils.ShowDetailsLoadCallback callback) {
        new ShowDetailsTask(page, callback).execute();
    }

    private class ShowDetailsTask extends AsyncTask<Void, Void, Void> {

        private int mPage;
        private NetworkUtils.ShowDetailsLoadCallback mCallback;

        ShowDetailsTask(int page, NetworkUtils.ShowDetailsLoadCallback callback) {
            mPage = page;
            mCallback = callback;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            api.getShowDetails(mPage, NetworkUtils.API_KEY).enqueue(new Callback<ShowDetails>() {
                @Override
                public void onResponse(@NonNull Call<ShowDetails> call, @NonNull Response<ShowDetails> response) {
                    mCallback.onLoadSuccess(response, response.body());
                }

                @Override
                public void onFailure(@NonNull Call<ShowDetails> call, @NonNull Throwable t) {
                    mCallback.onLoadFail(call);
                }
            });
            return null;
        }
    }

    public void searchShows(String query, int page, NetworkUtils.ShowLoadCallback callback) {
        new SearchShowsTask(query, page, callback).execute();
    }

    private class SearchShowsTask extends AsyncTask<Void, Void, Void> {

        private String mQuery;
        private int mPage;
        private NetworkUtils.ShowLoadCallback mCallback;

        SearchShowsTask(String query, int page, NetworkUtils.ShowLoadCallback callback) {
            mQuery = query;
            mPage = page;
            mCallback = callback;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            api.searchShows(mQuery, mPage, NetworkUtils.API_KEY).enqueue(new Callback<ShowPageModel>() {
                @Override
                public void onResponse(@NonNull Call<ShowPageModel> call, @NonNull Response<ShowPageModel> response) {
                    mCallback.onLoadSuccess(response, response.body().getShowModels());
                }

                @Override
                public void onFailure(@NonNull Call<ShowPageModel> call, @NonNull Throwable t) {
                    mCallback.onLoadFail(call);
                }
            });

            return null;
        }
    }

}
