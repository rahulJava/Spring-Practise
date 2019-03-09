import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * A simple socket server
 * 
 */
public class MultiThreadedServer {
	private static final byte END_WAITING = 66;	

	private ServerSocket serverSocket;
	private int port;

	public MultiThreadedServer(int port) {
		this.port = port;
	}

	public void start() throws IOException, InterruptedException {

		serverSocket = new ServerSocket(port);
		System.out.println("Starting the socket server at port:" + port);

		Socket client = null;

		while (true) {	
			
			System.out.println("Waiting for clients...");
			client = serverSocket.accept();
			System.out.println("The following client has connected to the server:"
					+ client.getInetAddress().getCanonicalHostName());
			Thread t = Thread.currentThread(); 
			
			System.out.println("Current thread: " + t.getName());
			// A client has connected to this server. Send welcome message
			Thread thread = new Thread(new SocketClientHandler(client));
			thread.start();
			try
	        { 
	            System.out.println("Current Thread: "
	                  + Thread.currentThread().getName()); 
	            thread.join(); 
	        } 
	  
	        catch(Exception ex) 
	        { 
	            System.out.println("Exception has " + 
	                                "been caught" + ex); 
	        } 
			System.out.println("line no 37:"+SocketClientHandler.returnSignlaValue());
			if(SocketClientHandler.returnSignlaValue())
			{
				break;
			}
		}
		System.out.println("Out of the while loop");
		serverSocket.close();
	}

}