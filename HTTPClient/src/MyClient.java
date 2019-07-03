import java.io.IOException;

public class MyClient {

	public static void main(String[] args) throws IOException {

		String host = "";
		int port = 0;
		String command = "";
		String path = "";
		int signal = 0;
		// fetch the command line arguments entered by user
		if (args.length == 4) {
			host = args[0];
			port = Integer.parseInt(args[1]);
			command = args[2];
			path = args[3];
		} else if (args.length == 3 && args[2].equalsIgnoreCase("66")) {
			host = args[0];
			port = Integer.parseInt(args[1]);
			signal = Integer.parseInt(args[2]);
		} else {
			System.out
					.println("Invalid Arguments!!! Please enter valid arguments.");
			return;
		}

		// Method Check GET or PUT or Terminal Signal
		if ("GET".equals(command)) {
			MyClientImpl.getMethod(host, port, path);
		} else if ("PUT".equals(command)) {
			MyClientImpl.putMethod(host, port, path);
		} else if (signal == 66) {
			MyClientImpl.terminateServerSignal(host, port, signal);
		} else {
			System.out
					.println("Check the HTTP command! It should be either GET or PUT");
			return;
		}
	}

}