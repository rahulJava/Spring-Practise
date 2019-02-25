package com.client.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;



public class Client 
{
	public static void main(String[] args) throws UnknownHostException, IOException {
		//String host = args[0];
		//int port = Integer.parseInt(args[1]);
		//String command = args[2];
		//String path = "/Users/rahulratra/Downloads/content.html";

	String host = "localhost";
		int port = 9091;
	String command = "PUT";
		String path = "/Users/rahulratra/Downloads/content.html";
		
		// Method Check GET or PUT
		if ("GET".equals(command)) {
			Client.getMethod(host, port, path);
		} else if ("PUT".equals(command)) {
			Client.putMethod(host, port, path);
		}else{
			System.out.println("Check the HTTP command! It should be either GET or PUT");
			return;
		}
		
	}
	
	public static void putMethod(String host, int port, String file)
			throws UnknownHostException, IOException {

		// Opening Connection based on the port number 80(HTTP) and 443(HTTPS)
		Socket clientSocket = null;
		clientSocket = new Socket(host, port);

		System.out.println("======================================");
		System.out.println("Connected");
		System.out.println("======================================");

		PrintWriter request = new PrintWriter(clientSocket.getOutputStream(),
				true);
		BufferedReader response = new BufferedReader(new InputStreamReader(
				clientSocket.getInputStream()));

		// Sending request to the server
		// Building HTTP request header
		request.print("PUT /" + file + "/ HTTP/1.1\r\n"); // "+path+"
		request.print("Host: " + host+"\r\n");
		request.print("Accept-Language: en-us\r\n");
		request.print("Connection: Keep-Alive\r\n");
		request.print("Mozilla/4.0 (compatible; MSIE5.01; Windows NT)\r\n");
		request.print("Content-type: text/html\r\n");
		request.print("Content-Length: 0\r\n");
		request.print("\r\n");

		System.out.println("PUT Request Header Sent!");
		System.out.println("======================================");

		// Send the Data to be PUT
		String htmlContent = readHtmlFile(file);
		request.println(htmlContent);
		request.flush();

		System.out.println("PUT Data Sent!");
		System.out.println("======================================");

		// Receiving response from server
		String responseLine;
		while ((responseLine = response.readLine()) != null) {
			System.out.println(responseLine);
		}
		System.out.println("======================================");
		System.out.println("Response Recieved!!");
		System.out.println("======================================");
		request.close();
		response.close();
		clientSocket.close();
	}

	public static void getMethod(String host, int port, String path)
			throws IOException {
		
		Socket clientSocket = new Socket("localhost",9999);
		System.out.println("======================================");
		System.out.println("Connected");
		System.out.println("======================================");
		
		PrintWriter request = new PrintWriter(clientSocket.getOutputStream(),
				true);
		
		// Declare a listener to this url
				BufferedReader response = new BufferedReader(new InputStreamReader(
						clientSocket.getInputStream()));
				request.print("GET /" + path + "/ HTTP/1.1\r\n"); // "+path+"
				request.print("Host: " + host + "\r\n");
				request.print("Connection: close\r\n");
				request.print("Mozilla/4.0 (compatible; MSIE5.01; Windows NT)\r\n");
				request.print("\r\n");
				request.flush();
				System.out.println("Request Sent!");
				System.out.println("======================================");
				String responseLine;
				while ((responseLine = response.readLine()) != null) {
					System.out.println(responseLine);
				}
				System.out.println("======================================");
				System.out.println("Response Recieved!!");
				System.out.println("======================================");

				response.close();
				request.close();
				clientSocket.close();
	}
private static String readHtmlFile(String file) {
		
		BufferedReader reader;
		StringBuilder stringBuilder = new StringBuilder();
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = null;
			String ls = System.getProperty("line.separator");

			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(ls);
			}
			reader.close();
			
			
		} catch (FileNotFoundException e) {
			
			System.err.println(e.getMessage());
			System.out.println("Client side issue with file name");
			System.exit(1);
//			stringBuilder.setLength(0);
//			stringBuilder.append("Check the file name!");
//			return stringBuilder.toString();
			
		} catch (IOException e) {
			
			System.err.println(e.getMessage());
			System.exit(1);
//			stringBuilder.setLength(0);
//			stringBuilder.append("File has no text!");
//			return stringBuilder.toString();
		}
		return stringBuilder.toString();
	}

}
