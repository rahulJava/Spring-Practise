package com.socket.program;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client 
{
	public static void main(String[] args) throws IOException {
		
		Socket soc = new Socket("localhost",9999);
		FileInputStream fr = new FileInputStream("/Users/rahulratra/Downloads/ProgrammingAssignment (2).docx");
		byte[] b = new byte[2002];
		fr.read(b,0,b.length);
		OutputStream write = soc.getOutputStream();
		
		
		
	}

}
