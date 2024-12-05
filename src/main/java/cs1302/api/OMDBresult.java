package cs1302.api;

import com.google.gson.annotations.SerializedName;

/**
 * Class modeling a singular movie result from {@code OMDBresults}.
 */
public class OMDBresult {
    private OMDBresult res;

    @SerializedName("Title")
    public String title;

    @SerializedName("Year")
    public String year;

    @SerializedName("Poster")
    public String posterUrl;

} // OpenLibraryResult
