package com.chatapp.client.core;
import java.io.IOException;
import java.net.Socket;
import com.chatapp.shared.utils.Config;

public class Client {
	public static void main(String[] args) {
		
		try {
			Socket socket=new Socket(Config.HOST,Config.PORT);
			System.out.println("Successfully connected to server at "+Config.HOST);
		}
		catch(IOException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
		
	}

}
