import java.io.IOException;

class MyServer {

	public static void main(String[] args) throws InterruptedException {
		int portNumber = Integer.parseInt(args[0]);

		try {
			// initializing the Socket Server
			MultiThreadedServer socketServer = new MultiThreadedServer(
					portNumber);
			socketServer.start();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}