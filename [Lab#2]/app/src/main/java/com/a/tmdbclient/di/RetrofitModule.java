package com.a.tmdbclient.di;

import com.a.tmdbclient.data.NetworkUtils;
import com.a.tmdbclient.data.movies.MoviesApi;
import com.a.tmdbclient.data.people.PeopleApi;
import com.a.tmdbclient.data.shows.ShowsApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
class RetrofitModule {

    @Provides
    MoviesApi provideMovieAPI(Retrofit retrofit){
        return retrofit.create(MoviesApi.class);
    }

    @Provides
    PeopleApi providePeopleAPI(Retrofit retrofit){
        return retrofit.create(PeopleApi.class);
    }

    @Provides
    ShowsApi provideShowAPI(Retrofit retrofit){
        return retrofit.create(ShowsApi.class);
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient, GsonConverterFactory gsonConverterFactory){
        return new Retrofit.Builder()
                .baseUrl(NetworkUtils.BASE_URL)
                .addConverterFactory(gsonConverterFactory)
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(){
        return new OkHttpClient();
    }

    @Provides
    @Singleton
    GsonConverterFactory provideGsonConverterFactory(Gson gson){
        return GsonConverterFactory.create(gson);
    }

    @Provides
    @Singleton
    Gson provideGson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }

}
