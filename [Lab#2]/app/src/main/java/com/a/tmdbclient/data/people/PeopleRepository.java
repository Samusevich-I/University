package com.a.tmdbclient.data.people;

import android.os.AsyncTask;

import androidx.annotation.NonNull;

import com.a.tmdbclient.App;
import com.a.tmdbclient.data.NetworkUtils;
import com.a.tmdbclient.data.people.pojo.PeopleDetails;
import com.a.tmdbclient.data.people.pojo.PeoplePageModel;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PeopleRepository {

    @Inject
    PeopleApi api;

    public PeopleRepository() {
        App.getAppComponent().inject(this);
    }

    public void getPopularPeoples(int page, NetworkUtils.PeopleLoadCallback callback) {
        new PopularPeoplesTask(page, callback).execute();
    }

    private class PopularPeoplesTask extends AsyncTask<Void, Void, Void> {

        private int mPage;
        private NetworkUtils.PeopleLoadCallback mCallback;

        PopularPeoplesTask(int page, NetworkUtils.PeopleLoadCallback callback) {
            mPage = page;
            mCallback = callback;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            api.getPopularPeoples(mPage, NetworkUtils.API_KEY).enqueue(new Callback<PeoplePageModel>() {
                @Override
                public void onResponse(@NonNull Call<PeoplePageModel> call, @NonNull Response<PeoplePageModel> response) {
                    mCallback.onLoadSuccess(response, response.body().getResults());
                }

                @Override
                public void onFailure(@NonNull Call<PeoplePageModel> call, @NonNull Throwable t) {
                    mCallback.onLoadFail(call);
                }
            });
            return null;
        }
    }

    public void getPeopleDetails(int page, NetworkUtils.PeopleDetailsLoadCallback callback) {
        new PeopleDetailsTask(page, callback).execute();
    }

    private class PeopleDetailsTask extends AsyncTask<Void, Void, Void> {

        private int mPage;
        private NetworkUtils.PeopleDetailsLoadCallback mCallback;

        PeopleDetailsTask(int page, NetworkUtils.PeopleDetailsLoadCallback callback) {
            mPage = page;
            mCallback = callback;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            api.getPeopleDetails(mPage, NetworkUtils.API_KEY).enqueue(new Callback<PeopleDetails>() {
                @Override
                public void onResponse(@NonNull Call<PeopleDetails> call, @NonNull Response<PeopleDetails> response) {
                    mCallback.onLoadSuccess(response, response.body());
                }

                @Override
                public void onFailure(@NonNull Call<PeopleDetails> call, @NonNull Throwable t) {
                    mCallback.onLoadFail(call);
                }
            });
            return null;
        }
    }

    public void searchPeoples(String query, int page, NetworkUtils.PeopleLoadCallback callback) {
        new SearchPeoplesTask(query, page, callback).execute();
    }

    private class SearchPeoplesTask extends AsyncTask<Void, Void, Void> {

        private String mQuery;
        private int mPage;
        private NetworkUtils.PeopleLoadCallback mCallback;

        SearchPeoplesTask(String query, int page, NetworkUtils.PeopleLoadCallback callback) {
            mQuery = query;
            mPage = page;
            mCallback = callback;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            api.searchPeoples(mQuery, mPage, NetworkUtils.API_KEY).enqueue(new Callback<PeoplePageModel>() {
                @Override
                public void onResponse(@NonNull Call<PeoplePageModel> call, @NonNull Response<PeoplePageModel> response) {
                    mCallback.onLoadSuccess(response, response.body().getResults());
                }

                @Override
                public void onFailure(@NonNull Call<PeoplePageModel> call, @NonNull Throwable t) {
                    mCallback.onLoadFail(call);
                }
            });
            return null;
        }
    }

}
