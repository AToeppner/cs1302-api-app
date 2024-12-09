package cs1302.api;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.net.http.HttpResponse;


/**
 * Class modeling the response of a OpenAI ChatGPT 3.5 query.
 */

public class OpenAIResult {

    @SerializedName("content")
    String content;

    /**
     * returns the content from chatgpt.
     * @return content message from chatgpt.
     */

    public String getContent() {
        return content;
    }
}
