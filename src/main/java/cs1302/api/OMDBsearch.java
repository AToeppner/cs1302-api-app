package cs1302.api;

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
 * This class contains the static methods for querying the OMDB Search API and returning
 * the query's results.
 */
public class OMDBsearch {
    /** HTTP Client. */
    public static final HttpClient HTTP_CLIENT = HttpClient.newBuilder()
        .version(HttpClient.Version.HTTP_2)
        .followRedirects(HttpClient.Redirect.NORMAL)
        .build();

    /** GSON object. */
    public static Gson GSON = new GsonBuilder()
        .setPrettyPrinting()
        .create();

    /**
     * Searches the OMDB API for the specified query and returns the
     * JSON result.
     *
     * @param query the query string to search
     * @return the JSON result string
     * @throws Exception if any exception fires along with its message
     */
    public static String search(String query) throws Exception {
        try {
            String encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8);
            String url = String.format("https://www.omdbapi.com/?t=%s&apikey=a7b0fa2d",
                encodedQuery);
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
            HttpResponse<String> response = HTTP_CLIENT.
                send(request, HttpResponse.BodyHandlers.ofString());
            final int statusCode = response.statusCode();
            if (statusCode != 200) {
                throw new IOException("Response status code not 200: " + statusCode);
            }
            return response.body().trim(); // Return the response body
        } catch (IllegalArgumentException | IOException | InterruptedException e) {
            throw new Exception("Error during search: " + e.getMessage(), e);
        }
    }

    /**
     * Returns the {@code GSON} class object of the resulting JSON.
     *
     * @param json the given JSON string
     * @return the class object of the result
     */
    public static OMDBresults parseJSON(String json) {
        OMDBresults results = GSON.fromJson(json, OMDBresults.class);
        return results;
    } // parseJSON



} // OLSearchAPI
