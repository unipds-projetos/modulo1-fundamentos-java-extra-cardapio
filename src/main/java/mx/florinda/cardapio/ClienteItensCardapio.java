package mx.florinda.cardapio;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClienteItensCardapio {

    public static void main(String[] args) throws Exception {
        URI viaCepURI = URI.create("http://127.0.0.1:8000/itensCardapio.json");

        try (HttpClient client = HttpClient.newBuilder().build()) {
            HttpRequest request = HttpRequest.newBuilder().uri(viaCepURI).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
            String responseText = response.body();
            System.out.println(responseText);
        }
    }
}
