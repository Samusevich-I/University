package com.a.tmdbclient.ui.shows.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.a.tmdbclient.App;
import com.a.tmdbclient.R;
import com.a.tmdbclient.data.NetworkUtils;
import com.a.tmdbclient.data.shows.pojo.ShowDetails;
import com.a.tmdbclient.ui.shows.ShowsPresenter;
import com.bumptech.glide.Glide;

import javax.inject.Inject;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class ShowsDetailsActivity extends AppCompatActivity {

    @Inject
    ShowsPresenter presenter;
    private TextView title;
    private TextView tag;
    private TextView description;
    private TextView status;
    private TextView numberOfSeasons;
    private TextView release;
    private ImageView poster;
    private ImageView backdrop;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);
        App.getAppComponent().inject(this);
        init();

        int id = getIntent().getIntExtra("id", 0);
        presenter.getShowsDetails(id, this);
    }

    private void init() {
        title = findViewById(R.id.show_details_title);
        tag = findViewById(R.id.show_details_tag);
        description = findViewById(R.id.show_details_description);
        poster = findViewById(R.id.show_details_poster);
        progressBar = findViewById(R.id.show_details_progress_bar);
        backdrop = findViewById(R.id.show_details_backdrop);
        status = findViewById(R.id.show_details_budget);
        numberOfSeasons = findViewById(R.id.show_details_revenue);
        release = findViewById(R.id.show_details_release);
    }

    public void setDetails(ShowDetails details) {
        progressBar.setVisibility(View.GONE);
        title.setVisibility(View.VISIBLE);
        title.setText(details.getName());
        tag.setVisibility(View.VISIBLE);
        tag.setText(details.getType());
        description.setVisibility(View.VISIBLE);
        description.setText(details.getOverview());
        poster.setVisibility(View.VISIBLE);
        status.setText("Status - "+details.getStatus());
        numberOfSeasons.setText("Number of seasons :"+details.getNumberOfSeasons());
        release.setText("Release date: "+details.getFirstAirDate());
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
