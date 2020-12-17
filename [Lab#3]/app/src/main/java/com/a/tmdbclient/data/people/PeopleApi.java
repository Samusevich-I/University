package com.a.tmdbclient.data.people;

import com.a.tmdbclient.data.people.pojo.PeopleDetails;
import com.a.tmdbclient.data.people.pojo.PeoplePageModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PeopleApi {

    @GET("person/popular")
    Call<PeoplePageModel> getPopularPeoples(@Query("page") int page, @Query("api_key") String userKey);

    @GET("person/{person_id}")
    Call<PeopleDetails> getPeopleDetails(@Path("person_id") int id, @Query("api_key") String userKey);

    @GET("search/person")
    Call<PeoplePageModel> searchPeoples(@Query("query") String query, @Query("page") int page, @Query("api_key") String userKey);

}
