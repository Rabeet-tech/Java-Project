package com.chatapp.server.core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.chatapp.config.Config;

public class Server {

    public static void main(String[] args) {

        try {
            // ServerSocket
            ServerSocket serverSocket = new ServerSocket(Config.PORT);

            // Server start message
            System.out.println("Server started on port " + Config.PORT + ". Waiting for a client...");

            // Pauses until client connects (BLOCKING LINE)
            Socket clientSocket = serverSocket.accept();

            // Client connected message
            System.out.println("Client Connected from " + clientSocket.getInetAddress());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
