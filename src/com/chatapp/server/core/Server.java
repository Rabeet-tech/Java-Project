package com.chatapp.server.core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

import com.chatapp.config.Config;

public class Server {

    public static void main(String[] args) {

        try {
            // ServerSocket
            ServerSocket serverSocket = new ServerSocket(Config.PORT);

            // Server start message
            System.out.println("Server started on port " + Config.PORT + ". Waiting for a client...");

            // Wait for client
            Socket clientSocket = serverSocket.accept();

            // Client connected message
            System.out.println("Client Connected from " + clientSocket.getInetAddress());

            // ✅ Initialize streams
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));

            PrintWriter out = new PrintWriter(
                    clientSocket.getOutputStream(), true); // autoFlush = true

            Scanner consoleInput = new Scanner(System.in);

            // ✅ Chat loop
            while (true) {
                // Receive message
                String message = in.readLine();

                // Check if client disconnected
                if (message == null) {
                    System.out.println("Client disconnected.");
                    break;
                }

                // Print client message
                System.out.println("Client says: " + message);

                // Take reply from server user
                System.out.print("Enter reply: ");
                String reply = consoleInput.nextLine();

                // Send reply
                out.println(reply);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
