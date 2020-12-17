package com.a.tmdbclient.ui.movies.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.a.tmdbclient.App;
import com.a.tmdbclient.R;
import com.a.tmdbclient.data.NetworkUtils;
import com.a.tmdbclient.data.movies.pojo.MovieDetails;
import com.a.tmdbclient.ui.movies.MoviesPresenter;
import com.bumptech.glide.Glide;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        App.getAppComponent().inject(this);
        init();

        int id = getIntent().getIntExtra("id", 0);
        presenter.getMovieDetails(id,this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter = null;
        poster = null;
        backdrop = null;
    }

    private void init() {
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

    public void setDetails(MovieDetails details) {
        progressBar.setVisibility(View.GONE);
        title.setVisibility(View.VISIBLE);
        title.setText(details.getTitle());
        tag.setVisibility(View.VISIBLE);
        tag.setText(details.getTagline());
        description.setVisibility(View.VISIBLE);
        description.setText(details.getOverview());
        poster.setVisibility(View.VISIBLE);
        budget.setText("Budget - "+details.getBudget()+" $");
        revenue.setText("Revenue - "+details.getRevenue()+" $");
        release.setText("Release date: "+details.getReleaseDate());
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
