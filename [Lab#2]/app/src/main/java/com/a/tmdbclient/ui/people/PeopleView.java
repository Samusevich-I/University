package com.a.tmdbclient.ui.people;

import android.view.View;

public interface PeopleView {
    void init(View view);
    void setProgressBarVisibility(boolean visibility);
    void setSearchProgressBarVisibility(boolean visibility);
    void showNoInternetError();
    void showApiError(String error);
}
