package com.a.tmdbclient.ui.shows;

import android.view.View;

public interface ShowsView {
    void init(View view);
    void setProgressBarVisibility(boolean visibility);
    void setSearchProgressBarVisibility(boolean visibility);
    void showNoInternetError();
    void showApiError(String error);
}
