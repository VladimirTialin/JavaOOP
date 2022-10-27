package ru.geekbrains.http_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Server {
    private static final String WWW = " ";
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            for(;;) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                socket.getInputStream(), StandardCharsets.UTF_8));
                PrintWriter writer = new PrintWriter(
                        socket.getOutputStream());
                while (!reader.ready()) ;
                String line = reader.readLine();
                System.out.println(line);
                String[] temp = line.split(" ");

                while (reader.ready()) {
                    System.out.println(reader.readLine());
                }
//                Path filePath = Path.of(WWW, temp[1]);
//                if (Files.exists(filePath) && !Files.isDirectory(filePath)) {
//                    writer.println("HTTP/1.1 200 OK");
//                    writer.println("Content-Type: text/html; charset=utf-8");
//                    writer.println();
//                    try (BufferedReader br = Files.newBufferedReader(filePath)) {
//                        br.transferTo(writer);
//                    }
//                    writer.flush();
//                    continue;
//                }
                writer.println("HTTP/1.1 404 OK");
                writer.println("Content-Type: text/html; charset=utf-8");
                writer.println();
                writer.println("<h1>File not found!</h1>");
                writer.flush();
                socket.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
