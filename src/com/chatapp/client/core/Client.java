package com.chatapp.client.core;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import com.chatapp.shared.utils.Config;

public class Client {
	public static void main(String[] args) {
		
		try(Socket socket=new Socket(Config.HOST,Config.PORT);) {
	
			System.out.println("Successfully connected to server at "+Config.HOST);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		Scanner consoleInput= new Scanner(System.in);

	
		while (true) {
			
			System.out.print("Enter message ");
			String msg = consoleInput.nextLine();

			
			out.println(msg);

			String response = in.readLine();

		
			if (response == null) {
				System.out.println("Server disconnected");
				break;
			}

			
			System.out.println(Config.SERVER_PREFIX + response);
		}
		}
		catch(IOException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
			
		}
		

	}

}
