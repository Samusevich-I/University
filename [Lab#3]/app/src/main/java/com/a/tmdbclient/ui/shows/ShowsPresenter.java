package com.a.tmdbclient.ui.shows;

import android.content.Context;

import com.a.tmdbclient.App;
import com.a.tmdbclient.data.NetworkUtils;
import com.a.tmdbclient.data.shows.ShowsRepository;
import com.a.tmdbclient.data.shows.pojo.ShowDetails;
import com.a.tmdbclient.data.shows.pojo.ShowModel;
import com.a.tmdbclient.ui.shows.view.ShowsDetailsActivity;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

public class ShowsPresenter {

    @Inject
    ShowsRepository repository;
    private ShowsView mView;
    private ShowsRecyclerViewAdapter mAdapter;
    private String searchQuery;
    private int searchPage = 1;
    private Context context;

    public ShowsPresenter(){
        App.getAppComponent().inject(this);
    }

    public void setView(ShowsView view, Context context){
        mView = view;
        this.context = context;
    }

    public void setAdapter(ShowsRecyclerViewAdapter adapter) {
        mAdapter = adapter;
    }

    public void getShowsDetails(int id, final ShowsDetailsActivity activity) {
        repository.getShowDetails(id, new NetworkUtils.ShowDetailsLoadCallback() {
            @Override
            public void onLoadFail(Call call) {
            }

            @Override
            public void onLoadSuccess(Response response, ShowDetails showDetails) {
                activity.setDetails(showDetails);
            }
        });
    }

    public void addPopularShows(int page) {
        if (NetworkUtils.isInternetUnavailable(context)) {
            mView.showNoInternetError();
        } else {
            repository.getPopularShows(page, new NetworkUtils.ShowLoadCallback() {
                @Override
                public void onLoadFail(Call call) {
                    mView.showApiError(call.toString());
                }

                @Override
                public void onLoadSuccess(Response response, List<ShowModel> showModels) {
                    mAdapter.addData(showModels);
                    mView.setProgressBarVisibility(false);
                }
            });
        }
    }

    public void setPopularShows(int page) {
        if (NetworkUtils.isInternetUnavailable(context)) {
            mView.showNoInternetError();
        } else {
            repository.getPopularShows(page, new NetworkUtils.ShowLoadCallback() {
                @Override
                public void onLoadFail(Call call) {
                    mView.showApiError(call.toString());
                }

                @Override
                public void onLoadSuccess(Response response, List<ShowModel> showModels) {
                    mAdapter.setData(showModels);
                    mView.setProgressBarVisibility(false);
                }
            });
        }
    }

    public void addBestShows(int page) {
        if (NetworkUtils.isInternetUnavailable(context)) {
            mView.showNoInternetError();
        } else {
            repository.getTopRatedShows(page, new NetworkUtils.ShowLoadCallback() {
                @Override
                public void onLoadFail(Call call) {
                    mView.showApiError(call.toString());
                }

                @Override
                public void onLoadSuccess(Response response, List<ShowModel> showModels) {
                    mAdapter.addData(showModels);
                    mView.setProgressBarVisibility(false);
                }
            });
        }
    }

    public void setBestShows(int page) {
        if (NetworkUtils.isInternetUnavailable(context)) {
            mView.showNoInternetError();
        } else {
            repository.getTopRatedShows(page, new NetworkUtils.ShowLoadCallback() {
                @Override
                public void onLoadFail(Call call) {
                    mView.showApiError(call.toString());
                }

                @Override
                public void onLoadSuccess(Response response, List<ShowModel> showModels) {
                    mAdapter.setData(showModels);
                    mView.setProgressBarVisibility(false);
                }
            });
        }
    }

    public void addUpcomingShows(int page) {
        if (NetworkUtils.isInternetUnavailable(context)) {
            mView.showNoInternetError();
        } else {
            repository.getUpcomingShows(page, new NetworkUtils.ShowLoadCallback() {
                @Override
                public void onLoadFail(Call call) {
                    mView.showApiError(call.toString());
                }

                @Override
                public void onLoadSuccess(Response response, List<ShowModel> showModels) {
                    mAdapter.addData(showModels);
                    mView.setProgressBarVisibility(false);
                }
            });
        }
    }

    public void setUpcomingShows(int page) {
        if (NetworkUtils.isInternetUnavailable(context)) {
            mView.showNoInternetError();
        } else {
            repository.getUpcomingShows(page, new NetworkUtils.ShowLoadCallback() {
                @Override
                public void onLoadFail(Call call) {
                    mView.showApiError(call.toString());
                }

                @Override
                public void onLoadSuccess(Response response, List<ShowModel> showModels) {
                    mAdapter.setData(showModels);
                    mView.setProgressBarVisibility(false);
                }
            });
        }
    }

    public void addNowPlayingShows(int page) {
        if (NetworkUtils.isInternetUnavailable(context)) {
            mView.showNoInternetError();
        } else {
            repository.getNowPlayingShows(page, new NetworkUtils.ShowLoadCallback() {
                @Override
                public void onLoadFail(Call call) {
                    mView.showApiError(call.toString());
                }

                @Override
                public void onLoadSuccess(Response response, List<ShowModel> showModels) {
                    mAdapter.addData(showModels);
                    mView.setProgressBarVisibility(false);
                }
            });
        }
    }

    public void setNowPlayingShows(int page) {
        if (NetworkUtils.isInternetUnavailable(context)) {
            mView.showNoInternetError();
        } else {
            repository.getNowPlayingShows(page, new NetworkUtils.ShowLoadCallback() {
                @Override
                public void onLoadFail(Call call) {
                    mView.showApiError(call.toString());
                }

                @Override
                public void onLoadSuccess(Response response, List<ShowModel> showModels) {
                    mAdapter.setData(showModels);
                    mView.setProgressBarVisibility(false);
                }
            });
        }
    }

    public void searchShows(String query,int page) {
        if (NetworkUtils.isInternetUnavailable(context)) {
            mView.showNoInternetError();
        } else {
            mView.setSearchProgressBarVisibility(true);
            searchQuery = query;
            searchPage = page;
            repository.searchShows(query,page, new NetworkUtils.ShowLoadCallback() {
                @Override
                public void onLoadFail(Call call) {
                    mView.setSearchProgressBarVisibility(false);
                    mView.setProgressBarVisibility(false);
                    mView.showApiError(call.toString());
                }

                @Override
                public void onLoadSuccess(Response response, List<ShowModel> showModels) {
                    mView.setSearchProgressBarVisibility(false);
                    mAdapter.setSearchData(showModels);
                    mView.setProgressBarVisibility(false);
                }
            });
        }
    }

    public void searchMoreShows(){
        if (NetworkUtils.isInternetUnavailable(context)) {
            mView.showNoInternetError();
        } else {
            repository.searchShows(searchQuery,++searchPage,new  NetworkUtils.ShowLoadCallback() {
                @Override
                public void onLoadFail(Call call) {
                    mView.showApiError(call.toString());
                }

                @Override
                public void onLoadSuccess(Response response, List<ShowModel> showModels) {
                    mAdapter.addSearchData(showModels);
                    mView.setProgressBarVisibility(false);
                }

            });
        }
    }

}
