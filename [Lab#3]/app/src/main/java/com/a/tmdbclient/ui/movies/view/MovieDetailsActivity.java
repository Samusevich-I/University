package com.a.tmdbclient.ui.movies.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.a.tmdbclient.App;
import com.a.tmdbclient.R;
import com.a.tmdbclient.data.NetworkUtils;
import com.a.tmdbclient.data.movies.MoviesDatabaseRepository;
import com.a.tmdbclient.data.movies.pojo.MovieDetails;
import com.a.tmdbclient.data.movies.pojo.MovieDetailsItem;
import com.a.tmdbclient.ui.movies.MoviesPresenter;
import com.bumptech.glide.Glide;

import java.util.List;

import javax.inject.Inject;

import jp.wasabeef.glide.transformations.BlurTransformation;


public class MovieDetailsActivity extends AppCompatActivity {

    @Inject
    MoviesPresenter presenter;
    private TextView title;
    private TextView tag;
    private TextView description;
    private TextView budget;
    private TextView revenue;
    private TextView release;
    private ImageView poster;
    private ImageView backdrop;
    private ProgressBar progressBar;
    private Button favorite;
    private MoviesDatabaseRepository repository;
    private boolean isFavorite = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        repository = new MoviesDatabaseRepository(this);
        App.getAppComponent().inject(this);
        init();

        int id = getIntent().getIntExtra("id", 0);
        presenter.getMovieDetails(id, this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter = null;
        poster = null;
        backdrop = null;
    }

    private void init() {
        favorite = findViewById(R.id.movie_details_favorite_button);
        title = findViewById(R.id.movie_details_title);
        tag = findViewById(R.id.movie_details_tag);
        description = findViewById(R.id.movie_details_description);
        poster = findViewById(R.id.movie_details_poster);
        progressBar = findViewById(R.id.movie_details_progress_bar);
        backdrop = findViewById(R.id.movie_details_backdrop);
        budget = findViewById(R.id.movie_details_budget);
        revenue = findViewById(R.id.movie_details_revenue);
        release = findViewById(R.id.movie_details_release);
    }

    public void setDetails(final MovieDetails details) {

        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repository.insert(new MovieDetailsItem(details.getAdult(), details.getBackdropPath(), details.getBelongsToCollection(),
                        details.getBudget(), details.getHomepage(), details.getId(), details.getImdbId(), details.getOriginalLanguage(),
                        details.getOriginalTitle(), details.getOverview(), details.getPopularity(), details.getPosterPath(),
                        details.getReleaseDate(), details.getRevenue(), details.getRuntime(), details.getStatus(), details.getTagline(),
                        details.getTitle(), details.getVideo(), details.getVoteAverage(), details.getVoteCount()));
                Toast.makeText(getApplicationContext(), "Added to favorite", Toast.LENGTH_SHORT).show();
            }
        });

        progressBar.setVisibility(View.GONE);
        title.setVisibility(View.VISIBLE);
        title.setText(details.getTitle());
        tag.setVisibility(View.VISIBLE);
        tag.setText(details.getTagline());
        description.setVisibility(View.VISIBLE);
        description.setText(details.getOverview());
        poster.setVisibility(View.VISIBLE);
        budget.setText("Budget - " + details.getBudget() + " $");
        revenue.setText("Revenue - " + details.getRevenue() + " $");
        release.setText("Release date: " + details.getReleaseDate());
        Glide.with(this)
                .load(NetworkUtils.IMG_BIG_SIZE_URL.concat(details.getBackdropPath()))
                .centerCrop()
                .transform(new BlurTransformation(25))
                .into(backdrop);
        Glide.with(this)
                .load(NetworkUtils.IMG_BIG_SIZE_URL.concat(details.getPosterPath()))
                .into(poster);
    }

}
