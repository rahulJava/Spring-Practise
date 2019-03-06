import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SocketClientHandler implements Runnable {

	private Socket client;
	private int i=0;

	public SocketClientHandler(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {
		try {
			System.out.println("Thread started with name123456:"
					+ Thread.currentThread().getName());
			System.out.println("line 28");
			readResponse();
			return;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void readResponse() throws IOException, InterruptedException {

		try {

			System.out.println("-----");
			BufferedReader request = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
			BufferedWriter response = new BufferedWriter(
					new OutputStreamWriter(client.getOutputStream()));

			System.out.println("Inside line no 44");
			String putDataFromClient = "";
			String requestHeader = "";
			String temp = ".";
			while (!temp.equals("")) {
				temp = request.readLine();
				System.out.println(temp);
				requestHeader += temp + "\n";
			}
			System.out.println("Line 55:"+requestHeader);

			// Get the method from HTTP header
			StringBuilder sb = new StringBuilder();
			String file = requestHeader.substring(requestHeader.indexOf("/")+1,requestHeader.indexOf(".txt")).trim();
			System.out.println("file:"+file);
			System.out.println("line no 61");
			System.out.println("=============");
			System.out.println("header123:"+requestHeader);
			System.out.println("=============");
			System.out.println("true or false:"+requestHeader.split("\n")[0].contains("PUT"));
			System.out.println("line no 67");
			if (requestHeader.split("\n")[0].contains("GET")
					&& checkURL(file+".txt")) {

				System.out.println("Hi Inside line no 73");
				// Get the correct page
				constructResponseHeader(200, sb);
				response.write(sb.toString());
				response.write(getData(file+".txt"));
				sb.setLength(0);
				response.flush();
			} else if (requestHeader.split("\n")[0].contains("PUT")) {

				System.out.println("line n0 75");
				System.out.println("hi inside lino number 70");
				// Get the data from the inputStream
				
				StringBuilder sb1 = new StringBuilder();
				putDataFromClient = request.readLine();
				System.out.println("putdatafromclient:"+putDataFromClient.length());
				while (putDataFromClient != null && putDataFromClient.length()!=0) {
					System.out.println("line no 87:"+putDataFromClient);
					sb1.append(putDataFromClient).append("\n");
					putDataFromClient =request.readLine().trim();
			    }
					
				String dataStream=sb1.toString();
				System.out.println("data from client:"+sb1.toString());

				// PUT the data to file serverIndex.html
				if (dataStream != "") {
					System.out.println("line no 96");
					int responseCode = putData(dataStream, file);
					constructResponseHeader(responseCode, sb);
					response.write(sb.toString());
					sb.setLength(0);
					response.flush();
				} else {
					constructResponseHeader(304, sb);
					response.write(sb.toString());
					sb.setLength(0);
					response.flush();
				}

			} else {
				// Enter the error code
				// 404 page not found
				constructResponseHeader(404, sb);
				response.write(sb.toString());
				sb.setLength(0);
				response.flush();
			}

			request.close();
			response.close();

			client.close();
			return;
		} catch (Exception e) {
			System.out.println("exception trace:::"+e.getMessage());
		}

	}

	// Check the URL from the Request header to the server's database
	private static boolean checkURL(String file) {

		System.out.println("file:"+file);
		File myFile = new File(file);
//		System.out.println(file);
//		System.out.println("IT IS CHEKCING");
//		System.out.println(myFile.exists() && !myFile.isDirectory());
		return myFile.exists() && !myFile.isDirectory();

	}

	// Construct Response Header
	private static void constructResponseHeader(int responseCode,
			StringBuilder sb) {

		if (responseCode == 200) {

			sb.append("HTTP/1.1 200 OK\r\n");
			sb.append("Date:" + getTimeStamp() + "\r\n");
			sb.append("Server:localhost\r\n");
			sb.append("Content-Type: text/html\r\n");
			sb.append("Connection: Closed\r\n\r\n");

		} else if (responseCode == 404) {

			sb.append("HTTP/1.1 404 Not Found\r\n");
			sb.append("Date:" + getTimeStamp() + "\r\n");
			sb.append("Server:localhost\r\n");
			sb.append("\r\n");
		} else if (responseCode == 304) {
			sb.append("HTTP/1.1 304 Not Modified\r\n");
			sb.append("Date:" + getTimeStamp() + "\r\n");
			sb.append("Server:localhost\r\n");
			sb.append("\r\n");
		}
	}

	// PUT data to file ServerIndex.htm
	private static int putData(String putDataFromClient, String file)
			throws IOException {

		return writeHtmlFile(putDataFromClient, file);
	}


	private static String getData(String file) {
		
		 StringBuilder sb = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
		   

		    String line = br.readLine();
		    while (line != null) {
		      sb.append(line).append("\n");
		      line = br.readLine();
		    }

		    String fileAsString = sb.toString();
			
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
		return sb.toString();
	}
	// Write the data to server - Helper method for putData method
	private static int writeHtmlFile(String putDataFromClient, String file) {

		System.out.println("line 204:"+putDataFromClient);
		System.out.println("location of the file:"+file);
		File myFile = new File(file+System.currentTimeMillis()+".txt");
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(myFile));
			writer.write(putDataFromClient);
			writer.close();
			return 200;
		} catch (IOException e) {
			return 304;
		}
	}

	// TimeStamp
	private static String getTimeStamp() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
		String formattedDate = sdf.format(date);
		return formattedDate;
	}

}
