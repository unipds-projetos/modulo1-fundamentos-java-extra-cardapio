package mx.florinda.cardapio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteItensCardapioComSocket {

    public static void main(String[] args) throws Exception {

        try(Socket socket = new Socket("localhost", 8000)) {
            OutputStream clientOS = socket.getOutputStream();
            PrintStream clientOut = new PrintStream(clientOS);
            clientOut.println("GET /itensCardapio.json HTTP/1.1");
            clientOut.println();

            InputStream clientIS = socket.getInputStream();
            Scanner scanner = new Scanner(clientIS);
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        }

    }

}
