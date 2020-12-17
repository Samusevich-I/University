package com.a.tmdbclient.data.people.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PeopleDetails {

    @SerializedName("birthday")
    @Expose
    private String birthday;
    @SerializedName("known_for_department")
    @Expose
    private String knownForDepartment;
    @SerializedName("deathday")
    @Expose
    private Object deathday;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("also_known_as")
    @Expose
    private List<String> alsoKnownAs = null;
    @SerializedName("gender")
    @Expose
    private Integer gender;
    @SerializedName("biography")
    @Expose
    private String biography;
    @SerializedName("popularity")
    @Expose
    private Double popularity;
    @SerializedName("place_of_birth")
    @Expose
    private String placeOfBirth;
    @SerializedName("profile_path")
    @Expose
    private String profilePath;
    @SerializedName("adult")
    @Expose
    private Boolean adult;
    @SerializedName("imdb_id")
    @Expose
    private String imdbId;
    @SerializedName("homepage")
    @Expose
    private Object homepage;

    public PeopleDetails() {
    }

    public PeopleDetails(String birthday, String knownForDepartment, Object deathday, Integer id,
                         String name, List<String> alsoKnownAs, Integer gender, String biography,
                         Double popularity, String placeOfBirth, String profilePath, Boolean adult,
                         String imdbId, Object homepage) {
        super();
        this.birthday = birthday;
        this.knownForDepartment = knownForDepartment;
        this.deathday = deathday;
        this.id = id;
        this.name = name;
        this.alsoKnownAs = alsoKnownAs;
        this.gender = gender;
        this.biography = biography;
        this.popularity = popularity;
        this.placeOfBirth = placeOfBirth;
        this.profilePath = profilePath;
        this.adult = adult;
        this.imdbId = imdbId;
        this.homepage = homepage;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getKnownForDepartment() {
        return knownForDepartment;
    }

    public Object getDeathday() {
        return deathday;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getAlsoKnownAs() {
        return alsoKnownAs;
    }

    public Integer getGender() {
        return gender;
    }

    public String getBiography() {
        return biography;
    }

    public Double getPopularity() {
        return popularity;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public String getProfilePath() {
        return profilePath;
    }

    public Boolean getAdult() {
        return adult;
    }

    public String getImdbId() {
        return imdbId;
    }

    public Object getHomepage() {
        return homepage;
    }

}
