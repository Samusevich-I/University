package com.a.tmdbclient.ui.people.view;

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
import com.a.tmdbclient.ui.people.PeoplePresenter;
import com.a.tmdbclient.ui.people.PeopleRecyclerViewAdapter;
import com.a.tmdbclient.ui.people.PeopleView;

import javax.inject.Inject;

public class PeopleFragment extends Fragment implements PeopleView,SwipeRefreshLayout.OnRefreshListener {

    @Inject
    PeoplePresenter presenter;
    private SwipeRefreshLayout swipeLayout;
    private ProgressBar searchProgressBar;
    private RecyclerView recyclerView;
    private PeopleRecyclerViewAdapter adapter;
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
        presenter = null;
        swipeLayout.setOnRefreshListener(null);
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_peoples, container, false);
        App.getAppComponent().inject(this);
        init(root);

        endlessScrollListener = new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                if (!adapter.isSearchDataMain()) {
                    presenter.addPopularPeoples(++dataPage);
                } else {
                    presenter.searchMorePeoples();
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
                    presenter.searchPeoples(s.toString().trim(), searchPage);
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
        recyclerView = view.findViewById(R.id.peoples_recycler_view);
        searchEditText = view.findViewById(R.id.peoples_search_edit_text);
        searchProgressBar = view.findViewById(R.id.peoples_search_progress_bar);
        internetErrorTextView = view.findViewById(R.id.peoples_internet_error);

        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new PeopleRecyclerViewAdapter();
        recyclerView.setAdapter(adapter);

        swipeLayout.setOnRefreshListener(this);

        presenter.setView(this, getContext());
        presenter.setAdapter(adapter);
        presenter.addPopularPeoples(dataPage);
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
            presenter.setPopularPeoples(dataPage);
        } else {
            presenter.searchPeoples(searchQuery,searchPage);
        }
    }
}