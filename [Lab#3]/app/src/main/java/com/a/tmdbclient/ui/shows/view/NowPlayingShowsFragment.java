package com.a.tmdbclient.ui.shows.view;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.a.tmdbclient.App;
import com.a.tmdbclient.R;
import com.a.tmdbclient.ui.EndlessRecyclerViewScrollListener;
import com.a.tmdbclient.ui.shows.ShowsPresenter;
import com.a.tmdbclient.ui.shows.ShowsRecyclerViewAdapter;
import com.a.tmdbclient.ui.shows.ShowsView;

import javax.inject.Inject;

public class NowPlayingShowsFragment extends Fragment implements ShowsView, SwipeRefreshLayout.OnRefreshListener {

    @Inject
    ShowsPresenter presenter;
    private ProgressBar searchProgressBar;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeLayout;
    private ShowsRecyclerViewAdapter adapter;
    private EditText searchEditText;
    private LinearLayoutManager linearLayoutManager;
    private TextView internetErrorTextView;
    private EndlessRecyclerViewScrollListener endlessScrollListener;
    private String searchQuery;
    private int dataPage = 1;
    private int searchPage = 1;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        recyclerView.removeOnScrollListener(endlessScrollListener);
        linearLayoutManager = null;
        recyclerView.setAdapter(null);
        presenter =  null;
        swipeLayout.setOnRefreshListener(null);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_shows, container, false);
        App.getAppComponent().inject(this);
        init(root);

        endlessScrollListener = new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                if (!adapter.isSearchDataMain()) {
                    presenter.addNowPlayingShows(++dataPage);
                } else {
                    presenter.searchMoreShows();
                }
            }
        };
        recyclerView.addOnScrollListener(endlessScrollListener);

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                setSearchProgressBarVisibility(true);
                if (!s.toString().trim().isEmpty()) {
                    searchQuery = s.toString().trim();
                    presenter.searchShows(s.toString().trim(), searchPage);
                    adapter.setSearchDataMain(true);
                    dataPage = 1;
                } else {
                    adapter.setSearchDataMain(false);
                    searchQuery = "";
                    searchPage = 1;
                    setSearchProgressBarVisibility(false);
                }
            }

        });

        return root;
    }

    @Override
    public void init(View view) {
        swipeLayout = view.findViewById(R.id.swipe_layout);
        recyclerView = view.findViewById(R.id.shows_recycler_view);
        searchEditText = view.findViewById(R.id.shows_search_edit_text);
        searchProgressBar = view.findViewById(R.id.shows_search_progress_bar);
        internetErrorTextView = view.findViewById(R.id.shows_internet_error);

        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new ShowsRecyclerViewAdapter();
        recyclerView.setAdapter(adapter);

        swipeLayout.setOnRefreshListener(this);

        presenter.setView(this, getContext());
        presenter.setAdapter(adapter);
        presenter.addNowPlayingShows(dataPage);
    }

    @Override
    public void setProgressBarVisibility(boolean visibility) {
        if (visibility) {
            swipeLayout.setRefreshing(true);
            recyclerView.setVisibility(View.GONE);
        } else {
            swipeLayout.setRefreshing(false);
            recyclerView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void setSearchProgressBarVisibility(boolean visibility) {
        if (visibility) {
            searchProgressBar.setVisibility(View.VISIBLE);
        } else {
            searchProgressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void showNoInternetError() {
        swipeLayout.setRefreshing(false);
        recyclerView.setVisibility(View.GONE);
        internetErrorTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showApiError(String error) {

    }

    @Override
    public void onRefresh() {
        dataPage = 1;
        searchPage = 1;
        if (!adapter.isSearchDataMain()) {
            presenter.setNowPlayingShows(dataPage);
        } else {
            presenter.searchShows(searchQuery,searchPage);
        }
    }

}