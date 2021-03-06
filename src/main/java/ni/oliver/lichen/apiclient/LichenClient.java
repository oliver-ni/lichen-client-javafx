package ni.oliver.lichen.apiclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;

/**
 * A client in charge of making requests to the API and parsing results.
 */
public class LichenClient {
    private static final URI ENDPOINT_URI = URI.create("https://lichen.oliver.ni/compare");
    private HttpClient client = HttpClient.newHttpClient();
    private Gson gson = new Gson();

    /**
     * Sends a request to the Lichen API.
     * 
     * @param req the request.
     * @return the result.
     * @throws IOException          if something bad happened.
     * @throws InterruptedException also if something bad happened.
     */
    public Result request(Request req) throws IOException, InterruptedException {
        var body = gson.toJson(req);

        var request = HttpRequest.newBuilder().uri(ENDPOINT_URI).POST(BodyPublishers.ofString(body))
                .header("Content-Type", "application/json").build();

        var response = client.send(request, BodyHandlers.ofString());
        var result = gson.fromJson(response.body(), Response.class).getValue();
        return result;
    }
}
