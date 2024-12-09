package cs1302.api;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.net.http.HttpHeaders;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * This class contains the methods for querying a generated book summary from
 * OpenAI's ChatGPT through the OpenAI API.
 */
public class OpenAIAPI {
    /** HTTP Client. */
    public static final HttpClient HTTP_CLIENT = HttpClient.newBuilder()
        .version(HttpClient.Version.HTTP_2)
        .followRedirects(HttpClient.Redirect.NORMAL)
        .build();

    /** GSON object. */
    public static Gson GSON = new GsonBuilder()
        .setPrettyPrinting()
        .create();

    /** OpenAI API key. */
    private final String apiKey;

    /**
     * Constructor to get API KEY from properties file.
     */
    public OpenAIAPI() {
        String configPath = "resources/config.properties";
        FileInputStream configFileStream = null;
        Properties config = null;
        try {
            configFileStream = new FileInputStream(configPath);
            System.out.println("config found");
            config = new Properties();
            config.load(configFileStream);
            config.list(System.out);
        } catch (IOException e) {
            e.printStackTrace();
            config = null;
        }

        this.apiKey = config.getProperty("OPEN_AI_KEY"); // OpenAI API_KEY

    } // OpenAIAPI

    /**
     * Queries the OpenAI API to generate a book summary using ChatGPT 3.5.
     *
     * @param query the query string to search
     * @return the JSON result string
     * @throws Exception if any exception fires along with its message
     */
    public String search(String query) throws Exception {
        try {
            String prompt = "Summarize the following Movie: " + query;
            String requestBody = "{\n"
                + "\t\"model\": \"gpt-3.5-turbo-0125\",\n"
                + "\t\"messages\": [{\"role\": \"user\", \"content\": \"" + prompt + "\"}],\n"
                + "\t\"temperature\": 0.7\n"
                + "}";
            String url = "https://api.openai.com/v1/chat/completions";
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + apiKey)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
            HttpResponse<String> response = HTTP_CLIENT
                .send(request, BodyHandlers.ofString());
            HttpHeaders headers = response.headers(); // Check rate limit headers

            String jsonBody = response.body();
            OpenAIResults openAIResponse = GSON.fromJson(jsonBody, OpenAIResults.class);

            String content = openAIResponse.choices[0].message.content;

            final int statusCode = response.statusCode();
            if (statusCode != 200) {
                throw new IOException("Status code not 200:" + statusCode + response.body());
            } // if
            return response.body().trim();
        } catch (IllegalArgumentException | IOException | InterruptedException e) {
            throw new Exception(e.toString());
        } // try
    } // search

    /**
     * Returns the {@code GSON} class object of the resulting JSON.
     * @param json the given JSON string
     * @return result the class object of the result
     */
    public OpenAIResults parseJSON(String json) {
        OpenAIResults result = GSON.fromJson(json, OpenAIResults.class);
        return result;
    } // parseJSON

} // OpenAIAPI
