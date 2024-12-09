package cs1302.api;

import com.google.gson.annotations.SerializedName;

/**
 * Class modeling the results of a OpenAI ChatGPT 3.5 query.
 */
public class OpenAIResults {
    @SerializedName("choices")
    OpenAIChoice[] choices;
} // OpenAIResults
