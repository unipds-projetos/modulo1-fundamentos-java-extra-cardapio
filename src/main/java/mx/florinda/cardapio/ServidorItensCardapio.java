package mx.florinda.cardapio;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ServidorItensCardapio {

    public static void main(String[] args) throws IOException {
        int porta = 8000;
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(porta), 0);
        httpServer.createContext("/itensCardapio.json", (HttpExchange exchange) -> {
            Path arquivoItens = Path.of("itensCardapio.json");
            String itensCardapioJson = Files.readString(arquivoItens);

            byte[] body = itensCardapioJson.getBytes(StandardCharsets.UTF_8);

            Headers responseHeaders = exchange.getResponseHeaders();
            responseHeaders.add("Content-Type", "application/json; charset=UTF-8");

            exchange.sendResponseHeaders(200, body.length);
            try(OutputStream responseBody = exchange.getResponseBody()){
                responseBody.write(body);
            }
        });
        System.out.println("Iniciando servidor na porta " + porta);
        httpServer.start();
    }

}
