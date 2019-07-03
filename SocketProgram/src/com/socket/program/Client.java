package com.socket.program;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {

		Socket sock = new Socket("127.0.0.1", 9999);
		System.out.println("Connected to the server..");

		String product = "sadfsdf";
		
		InputStream in = sock.getInputStream();
		OutputStream out = sock.getOutputStream();
		
		System.out.println("Sending product information..");
		out.write(product.getBytes());
		
		byte [] response = new byte[100];
		in.read(response);
		
		String strResponse = new String(response).trim();
		
		System.out.println("Obtained response is - " + strResponse);
		
		sock.close();
		
	}

}
