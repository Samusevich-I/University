package com.a.tmdbclient.data.people.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PeoplePageModel {

    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("results")
    @Expose
    private List<PeopleModel> results = null;

    public PeoplePageModel() {
    }

    public PeoplePageModel(Integer page, List<PeopleModel> results) {
        super();
        this.page = page;
        this.results = results;
    }

    public Integer getPage() {
        return page;
    }

    public List<PeopleModel> getResults() {
        return results;
    }

}