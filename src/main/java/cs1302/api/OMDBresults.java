package cs1302.api;

import com.google.gson.annotations.SerializedName;

/**
 * Class modeling the results of the OMDB API.
 */
public class OMDBresults {
    @SerializedName("Title")
    public String title;

    @SerializedName("Year")
    public String year;

    @SerializedName("Poster")
    public String poster;

    @SerializedName("Plot")
    public String plot;

    @SerializedName("Director")
    public String director;
} // OMDBResults
