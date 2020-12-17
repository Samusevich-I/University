package com.a.tmdbclient.ui.movies;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.a.tmdbclient.R;
import com.a.tmdbclient.data.NetworkUtils;
import com.a.tmdbclient.data.movies.pojo.MovieModel;
import com.a.tmdbclient.ui.movies.view.MovieDetailsActivity;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MoviesRecyclerViewAdapter extends RecyclerView.Adapter<MoviesRecyclerViewAdapter.ViewHolder> {

    private List<MovieModel> mCategoryData;
    private List<MovieModel> mSearchData;
    private List<MovieModel> mData;
    private boolean isSearchDataMain;
    private Context mContext;

    public MoviesRecyclerViewAdapter() {
        mCategoryData = new ArrayList<>();
        mSearchData = new ArrayList<>();
        mData = new ArrayList<>();
        mData = mCategoryData;
    }

    void addData(List<MovieModel> data) {
        mCategoryData.addAll(data);
        notifyDataSetChanged();
    }

    public void setData(List<MovieModel> data) {
        mCategoryData.clear();
        mCategoryData.addAll(data);
        notifyDataSetChanged();
    }

    void addSearchData(List<MovieModel> data) {
        if (!mSearchData.containsAll(data)) {
            mSearchData.addAll(data);
            notifyDataSetChanged();
        }
    }

    void setSearchData(List<MovieModel> data) {
        mSearchData.clear();
        mSearchData.addAll(data);
        notifyDataSetChanged();
    }

    public boolean isSearchDataMain() {
        return isSearchDataMain;
    }

    public void setSearchDataMain(boolean b) {
        isSearchDataMain = b;
        if (isSearchDataMain) {
            mData = mSearchData;
        } else {
            mData = mCategoryData;
        }
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView titleTextView;
        TextView releaseTextView;
        TextView descriptionTextView;
        ImageView imageView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.item_title);
            releaseTextView = itemView.findViewById(R.id.item_release);
            imageView = itemView.findViewById(R.id.item_photo);
            descriptionTextView = itemView.findViewById(R.id.item_description);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mContext, MovieDetailsActivity.class);
            intent.putExtra("id", mData.get(getAdapterPosition()).getId());
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            mContext.startActivity(intent);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item, parent, false));
        mContext = parent.getContext();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        MovieModel item = mData.get(position);
        holder.titleTextView.setText(item.getTitle());
        holder.releaseTextView.setText(item.getReleaseDate());
        holder.descriptionTextView.setText(item.getOverview());
        Glide.with(mContext)
                .load(NetworkUtils.IMG_BASE_URL + item.getPosterPath())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

}
