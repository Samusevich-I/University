package com.a.tmdbclient.ui.movies;

import android.content.Context;

import com.a.tmdbclient.App;
import com.a.tmdbclient.data.NetworkUtils;
import com.a.tmdbclient.data.movies.MoviesDatabaseRepository;
import com.a.tmdbclient.data.movies.MoviesRepository;
import com.a.tmdbclient.data.movies.pojo.MovieDetails;
import com.a.tmdbclient.data.movies.pojo.MovieModel;
import com.a.tmdbclient.ui.movies.view.MovieDetailsActivity;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

public class MoviesPresenter {

    @Inject
    MoviesRepository repository;
    private MoviesDatabaseRepository databaseRepository;
    private MovieView mView;
    private MoviesRecyclerViewAdapter mAdapter;
    private FavMoviesViewAdapter favAdapter = new FavMoviesViewAdapter();
    private String searchQuery;
    private int searchPage = 1;
    private Context mContext;

    public MoviesPresenter() {
        App.getAppComponent().inject(this);
    }

    public void setView(MovieView view, Context context) {
        mView = view;
        mContext = context;
        mView.setRefreshing(true);
    }

    public void setAdapter(MoviesRecyclerViewAdapter adapter) {
        mAdapter = adapter;
    }

    public void getMovieDetails(int id, final MovieDetailsActivity activity) {
        repository.getMovieDetails(id, new NetworkUtils.MovieDetailsLoadCallback() {
            @Override
            public void onLoadFail(Call call) {
            }

            @Override
            public void onLoadSuccess(Response response, MovieDetails movieDetails) {
                activity.setDetails(movieDetails);
            }
        });
    }

    public void addPopularMovies(int page) {
        if (NetworkUtils.isInternetUnavailable(mContext)) {
            mView.showNoInternetError();
        } else {
            repository.getPopularMovies(page, new NetworkUtils.MovieListLoadCallback() {
                @Override
                public void onLoadFail(Call call) {
                    mView.showApiError(call.toString());
                }

                @Override
                public void onLoadSuccess(Response response, List<MovieModel> movieModels) {
                    if (mAdapter != null) {
                        mAdapter.addData(movieModels);
                        mView.setRefreshing(false);
                    }
                }
            });
        }
    }

    public void setPopularMovies(int page) {
        if (NetworkUtils.isInternetUnavailable(mContext)) {
            mView.showNoInternetError();
        } else {
            repository.getPopularMovies(page, new NetworkUtils.MovieListLoadCallback() {
                @Override
                public void onLoadFail(Call call) {
                    mView.showApiError(call.toString());
                }

                @Override
                public void onLoadSuccess(Response response, List<MovieModel> movieModels) {
                    mAdapter.setData(movieModels);
                    mView.setRefreshing(false);
                }
            });
        }
    }

    public void addUpcomingMovies(int page) {
        if (NetworkUtils.isInternetUnavailable(mContext)) {
            mView.showNoInternetError();
        } else {
            repository.getUpcomingMovies(page, new NetworkUtils.MovieListLoadCallback() {
                @Override
                public void onLoadFail(Call call) {
                    mView.showApiError(call.toString());
                }

                @Override
                public void onLoadSuccess(Response response, List<MovieModel> movieModels) {
                    if (mAdapter != null) {
                        mAdapter.addData(movieModels);
                        mView.setRefreshing(false);
                    }
                }
            });
        }
    }

    public void setUpcomingMovies(int page) {
        if (NetworkUtils.isInternetUnavailable(mContext)) {
            mView.showNoInternetError();
        } else {
            repository.getUpcomingMovies(page, new NetworkUtils.MovieListLoadCallback() {
                @Override
                public void onLoadFail(Call call) {
                    mView.showApiError(call.toString());
                }

                @Override
                public void onLoadSuccess(Response response, List<MovieModel> movieModels) {
                    mAdapter.addData(movieModels);
                    mView.setRefreshing(false);
                }
            });
        }
    }

    public void addTopRatedMovies(int page) {
        if (NetworkUtils.isInternetUnavailable(mContext)) {
            mView.showNoInternetError();
        } else {
            repository.getTopRatedMovies(page, new NetworkUtils.MovieListLoadCallback() {
                @Override
                public void onLoadFail(Call call) {
                    mView.showApiError(call.toString());
                }

                @Override
                public void onLoadSuccess(Response response, List<MovieModel> movieModels) {
                    if (mAdapter != null) {
                        mAdapter.addData(movieModels);
                        mView.setRefreshing(false);
                    }
                }
            });
        }
    }

    public void setTopRatedMovies(int page) {
        if (NetworkUtils.isInternetUnavailable(mContext)) {
            mView.showNoInternetError();
        } else {
            repository.getTopRatedMovies(page, new NetworkUtils.MovieListLoadCallback() {
                @Override
                public void onLoadFail(Call call) {
                    mView.showApiError(call.toString());
                }

                @Override
                public void onLoadSuccess(Response response, List<MovieModel> movieModels) {
                    mAdapter.setData(movieModels);
                    mView.setRefreshing(false);
                }
            });
        }
    }

    public void addNowPlayingMovies(int page) {
        if (NetworkUtils.isInternetUnavailable(mContext)) {
            mView.showNoInternetError();
        } else {
            repository.getNowPlayingMovies(page, new NetworkUtils.MovieListLoadCallback() {
                @Override
                public void onLoadFail(Call call) {
                    mView.showApiError(call.toString());
                }

                @Override
                public void onLoadSuccess(Response response, List<MovieModel> movieModels) {
                    if (mAdapter != null) {
                        mAdapter.addData(movieModels);
                        mView.setRefreshing(false);
                    }
                }
            });
        }
    }

    public void getFavMovies(Context context, MoviesDatabaseRepository.LoadCallback callback){
        databaseRepository = new MoviesDatabaseRepository(context);
        databaseRepository.getElementsList(callback);
    }

    public void setNowPlayingMovies(int page) {
        if (NetworkUtils.isInternetUnavailable(mContext)) {
            mView.showNoInternetError();
        } else {
            repository.getNowPlayingMovies(page, new NetworkUtils.MovieListLoadCallback() {
                @Override
                public void onLoadFail(Call call) {
                    mView.showApiError(call.toString());
                }

                @Override
                public void onLoadSuccess(Response response, List<MovieModel> movieModels) {
                    mAdapter.setData(movieModels);
                    mView.setRefreshing(false);
                }
            });
        }
    }

    public void searchMovies(String query, int page) {
        if (NetworkUtils.isInternetUnavailable(mContext)) {
            mView.showNoInternetError();
        } else {
            searchQuery = query;
            searchPage = page;
            repository.searchMovies(query, page, new NetworkUtils.MovieListLoadCallback() {
                @Override
                public void onLoadFail(Call call) {
                    mView.showApiError(call.toString());
                    mView.setSearchProgressBarVisibility(false);
                }

                @Override
                public void onLoadSuccess(Response response, List<MovieModel> movieModels) {
                    mAdapter.setSearchData(movieModels);
                    mView.setSearchProgressBarVisibility(false);
                    mView.setRefreshing(false);
                }
            });
        }
    }

    public void searchMoreMovies() {
        if (NetworkUtils.isInternetUnavailable(mContext)) {
            mView.showNoInternetError();
        } else {
            repository.searchMovies(searchQuery, ++searchPage, new NetworkUtils.MovieListLoadCallback() {
                @Override
                public void onLoadFail(Call call) {
                    mView.showApiError(call.toString());
                }

                @Override
                public void onLoadSuccess(Response response, List<MovieModel> movieModels) {
                    mAdapter.addSearchData(movieModels);
                    mView.setRefreshing(false);
                }
            });
        }
    }

}
