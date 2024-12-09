package cs1302.api;

import com.google.gson.annotations.SerializedName;

/**
 * Class modeling the results of the OMDB API.
 */
public class OMDBresults {
    @SerializedName("Title")
    String title;

    @SerializedName("Year")
    String year;

    @SerializedName("Poster")
    String poster;

    @SerializedName("Rated")
    String rated;

    @SerializedName("Released")
    String released;

    @SerializedName("Runtime")
    String runtime;

    @SerializedName("Genre")
    String genre;

    @SerializedName("Awards")
    String awards;

    @SerializedName("Actors")
    String actors;

    @SerializedName("imdbRating")
    String imdbRating;

    @SerializedName("Director")
    String director;
} // OMDBResults
