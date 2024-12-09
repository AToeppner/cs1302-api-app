package cs1302.api;

import com.google.gson.annotations.SerializedName;

/**
 * class modeling the message from OpenAI GPT.
 */

public class OpenAIMessage {

    @SerializedName("content")
    String content;

} // OpenAIMessage
