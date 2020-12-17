package com.a.tmdbclient.ui.movies;

import android.view.View;

public interface MovieView {
    void init(View view);
    void setRefreshing(boolean visibility);
    void setSearchProgressBarVisibility(boolean visibility);
    void showNoInternetError();
    void showApiError(String error);
}
