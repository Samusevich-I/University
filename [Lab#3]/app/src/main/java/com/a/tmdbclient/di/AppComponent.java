package com.a.tmdbclient.di;

import com.a.tmdbclient.data.movies.MoviesRepository;
import com.a.tmdbclient.data.people.PeopleRepository;
import com.a.tmdbclient.data.shows.ShowsRepository;
import com.a.tmdbclient.ui.main.MainActivity;
import com.a.tmdbclient.ui.movies.MoviesPresenter;
import com.a.tmdbclient.ui.movies.view.FavoriteMoviesFragment;
import com.a.tmdbclient.ui.movies.view.MovieDetailsActivity;
import com.a.tmdbclient.ui.movies.view.NowPlayingMoviesFragment;
import com.a.tmdbclient.ui.movies.view.PopularMoviesFragment;
import com.a.tmdbclient.ui.movies.view.TopRatedMoviesFragment;
import com.a.tmdbclient.ui.movies.view.UpcomingMoviesFragment;
import com.a.tmdbclient.ui.people.PeoplePresenter;
import com.a.tmdbclient.ui.people.view.PeopleDetailsActivity;
import com.a.tmdbclient.ui.people.view.PeopleFragment;
import com.a.tmdbclient.ui.shows.ShowsPresenter;
import com.a.tmdbclient.ui.shows.view.NowPlayingShowsFragment;
import com.a.tmdbclient.ui.shows.view.PopularShowsFragment;
import com.a.tmdbclient.ui.shows.view.ShowsDetailsActivity;
import com.a.tmdbclient.ui.shows.view.TopRatedShowsFragment;
import com.a.tmdbclient.ui.shows.view.UpcomingShowsFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {RetrofitModule.class, RepositoryModule.class, PresenterModule.class})
public interface AppComponent {

    void inject(PopularMoviesFragment fragment);
    void inject(NowPlayingMoviesFragment fragment);
    void inject(TopRatedMoviesFragment fragment);
    void inject(UpcomingMoviesFragment fragment);
    void inject(FavoriteMoviesFragment fragment);
    void inject(PopularShowsFragment fragment);
    void inject(NowPlayingShowsFragment fragment);
    void inject(TopRatedShowsFragment fragment);
    void inject(UpcomingShowsFragment fragment);
    void inject(PeopleFragment fragment);

    void inject(PeopleDetailsActivity activity);
    void inject(ShowsDetailsActivity activity);
    void inject(MovieDetailsActivity activity);
    void inject(MainActivity activity);

    void inject(MoviesRepository networkManager);
    void inject(ShowsRepository networkManager);
    void inject(PeopleRepository networkManager);

    void inject(MoviesPresenter presenter);
    void inject(ShowsPresenter presenter);
    void inject(PeoplePresenter presenter);

}
