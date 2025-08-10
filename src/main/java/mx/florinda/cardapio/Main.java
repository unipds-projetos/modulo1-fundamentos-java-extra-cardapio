package mx.florinda.cardapio;


import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Database database = new Database();
        List<ItemCardapio> itensCardapio = database.listaItensCardapio();

        Gson gson = new Gson();
        String json = gson.toJson(itensCardapio);
        Path arquivoItens = Path.of("itensCardapio.json");
        Files.writeString(arquivoItens, json);
    }

}
