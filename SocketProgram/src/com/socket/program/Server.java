package com.socket.program;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server 
{
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(9999);
		Socket socket = server.accept();
		
		
		InputStream is = socket.getInputStream();
		FileOutputStream fr = new FileOutputStream("/Users/rahulratra/Downloads/assignmentccn (3).docx");
		byte [ ] b = new byte[10000];
		is.read(b,0,b.length);
		fr.write(b,0,b.length);
		
		
		
	}

}
