package mx.florinda.cardapio;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class ServidorItensCardapio {

    public static void main(String[] args) throws IOException {
        int porta = 8000;
        try(ServerSocket serverSocket = new ServerSocket(porta)) {
            System.out.println("Iniciando servidor na porta " + porta);

            try (Socket clientSocket = serverSocket.accept()) {
                System.out.println("Conectou com cliente " + clientSocket.getInetAddress());

                InputStream in = clientSocket.getInputStream();

                StringBuilder requestBuilder = new StringBuilder();
                int data;
                do {
                    data = in.read();
                    requestBuilder.append((char) data);
                } while(in.available()>0);

                String request = requestBuilder.toString();
                System.out.println(request);

                Database database = new Database();
                List<ItemCardapio> listaItensCardapio = database.listaItensCardapio();
                Gson gson = new Gson();
                String json = gson.toJson(listaItensCardapio);

                PrintStream out = new PrintStream(clientSocket.getOutputStream());
                out.println("HTTP/1.1 200 OK");
                out.println("Content-Type: application/json; charset=UTF-8");
                out.println("");
                out.print(json);
            }
        }
    }

}
