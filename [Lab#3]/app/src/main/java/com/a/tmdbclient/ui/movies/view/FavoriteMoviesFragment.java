package com.a.tmdbclient.ui.movies.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.a.tmdbclient.App;
import com.a.tmdbclient.R;
import com.a.tmdbclient.data.NetworkUtils;
import com.a.tmdbclient.data.movies.MoviesDatabaseRepository;
import com.a.tmdbclient.data.movies.pojo.MovieDetailsItem;
import com.a.tmdbclient.ui.movies.FavMoviesViewAdapter;
import com.a.tmdbclient.ui.movies.MoviesPresenter;

import java.util.List;

import javax.inject.Inject;


public class FavoriteMoviesFragment extends Fragment {

    @Inject
    MoviesPresenter presenter;
    private SwipeRefreshLayout swipeLayout;
    private RecyclerView recyclerView;
    private FavMoviesViewAdapter adapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        linearLayoutManager = null;
        recyclerView.setAdapter(null);
        presenter = null;
        swipeLayout.setOnRefreshListener(null);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_movies, container, false);
        App.getAppComponent().inject(this);
        init(root);

        return root;
    }

    public void init(View view) {
        swipeLayout = view.findViewById(R.id.swipe_layout);
        recyclerView = view.findViewById(R.id.movies_recycler_view);

        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new FavMoviesViewAdapter();
        recyclerView.setAdapter(adapter);
        presenter.getFavMovies(getContext(), new MoviesDatabaseRepository.LoadCallback() {
            @Override
            public List<MovieDetailsItem> onLoadFinished(List<MovieDetailsItem> itemList) {
                adapter.setData(itemList);
                if(NetworkUtils.isInternetUnavailable(getActivity())&itemList.size()==0){
                    Toast.makeText(getContext(),"No favorite movies added",Toast.LENGTH_SHORT).show();
                }
                return itemList;
            }

            @Override
            public void onLoadFailed() {

            }
        });

        Log.d("init","setdata");
    }

}