package com.a.tmdbclient.data;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.a.tmdbclient.data.movies.pojo.MovieDetails;
import com.a.tmdbclient.data.movies.pojo.MovieModel;
import com.a.tmdbclient.data.people.pojo.PeopleDetails;
import com.a.tmdbclient.data.people.pojo.PeopleModel;
import com.a.tmdbclient.data.shows.pojo.ShowDetails;
import com.a.tmdbclient.data.shows.pojo.ShowModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class NetworkUtils {

    public static final String BASE_URL = "https://api.themoviedb.org/3/";
    public static final String API_KEY = "9bd3b90bce7cf27fc87c740e0442a798";
    public static final String IMG_BASE_URL = "http://image.tmdb.org/t/p/w342/";
    public static final String IMG_BIG_SIZE_URL = "http://image.tmdb.org/t/p/w780/";


    public interface MovieListLoadCallback {
        void onLoadFail(Call call);
        void onLoadSuccess(Response response, List<MovieModel> movieModels);
    }

    public interface MovieDetailsLoadCallback {
        void onLoadFail(Call call);
        void onLoadSuccess(Response response, MovieDetails movieDetails);
    }

    public interface PeopleLoadCallback {
        void onLoadFail(Call call);
        void onLoadSuccess(Response response, List<PeopleModel> peopleModels);
    }

    public interface PeopleDetailsLoadCallback {
        void onLoadFail(Call call);
        void onLoadSuccess(Response response, PeopleDetails peopleDetails);
    }

    public interface ShowLoadCallback {
        void onLoadFail(Call call);
        void onLoadSuccess(Response response, List<ShowModel> showModels);
    }

    public interface ShowDetailsLoadCallback {
        void onLoadFail(Call call);
        void onLoadSuccess(Response response, ShowDetails showDetails);
    }

    public static boolean isInternetUnavailable(Context context) {
        final ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null) {
            return true;
        }
        final NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo == null || !networkInfo.isConnected();
    }

}
