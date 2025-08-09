package mx.florinda.cardapio;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        URI viaCepURI = URI.create("https://viacep.com.br/ws/01001000/json/");

        try (HttpClient client = HttpClient.newBuilder().build()) {
            HttpRequest request = HttpRequest.newBuilder().uri(viaCepURI).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
            String responseText = response.body();
            System.out.println(responseText);
        }

    }

}
