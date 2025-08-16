package mx.florinda.cardapio;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ClienteViaCEP {

    public static void main(String[] args) throws Exception {

        // URL url = new URL("https://viacep.com.br/ws/01001000/json/");

        URI uri = URI.create("https://viacep.com.br/ws/01001000/json/");


        try(HttpClient httpClient = HttpClient.newHttpClient()) {
            HttpRequest httpRequest = HttpRequest.newBuilder(uri).build();
            HttpResponse<String> httpResponse = httpClient.send(httpRequest,
                                                            HttpResponse.BodyHandlers.ofString());
            int statusCode = httpResponse.statusCode();
            String body = httpResponse.body();
            System.out.println(statusCode);
            System.out.println(body);
        }



    }


}
