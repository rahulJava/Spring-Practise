import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedServer {

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
			
			System.out
					.println("The following client has connected to the server:"
							+ client.getInetAddress().getCanonicalHostName());
			Thread t = Thread.currentThread();

			System.out.println("Current thread: " + t.getName());
			// A client has connected to this server
			Thread thread = new Thread(new SocketClientHandler(client));
			thread.start();
			try {
				System.out.println("Current Thread: "
						+ Thread.currentThread().getName());
				thread.join();
			}

			catch (Exception ex) {
				System.out.println("Exception has been caught" + ex);
			}
			System.out.println("SocketClientHandler.returnSignalValue() is:"
					+ SocketClientHandler.returnSignalValue());
			if (SocketClientHandler.returnSignalValue()) {
				break;
			}
		}
		System.out.println("Out of the while loop");
		serverSocket.close();
		System.out.println("======================================");
		System.out.println("Server is shut down now!!");
		System.out.println("======================================");
	}

}