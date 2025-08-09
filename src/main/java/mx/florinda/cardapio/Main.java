package mx.florinda.cardapio;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder responseTextBuilder = new StringBuilder();

        String viaCepURL = "https://viacep.com.br/ws/01001000/json/";

        try (Scanner scanner = new Scanner(new URL(viaCepURL).openStream())) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                responseTextBuilder.append(line);
            }
        }

        String responseText = responseTextBuilder.toString();
        System.out.println(responseText);

        Gson gson = new Gson();
        Map<String, String> dadosCep = gson.fromJson(responseText, new TypeToken<>() {
        });
        System.out.printf("%s, %s/%s", dadosCep.get("logradouro"),
                dadosCep.get("localidade"),
                dadosCep.get("uf"));

    }

}
