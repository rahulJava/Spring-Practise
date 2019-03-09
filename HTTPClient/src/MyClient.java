import java.io.IOException;


public class MyClient {

	public static void main(String[] args) throws IOException {

		String host="";
		int port=0;
		String command ="";
		String path="";
		int signal=0;
		if(args.length==4)
		{
		 host = args[0];
	     port = Integer.parseInt(args[1]);
		command = args[2];
	     path = args[3];
		}
		else
		{
			 host = args[0];
			 port = Integer.parseInt(args[1]);
			 signal=Integer.parseInt(args[2]);
		}
		
//
//		String host = "localhost";
//		int port = 9898;
//		String command = "PUT";
//		String path = "/Users/rahulratra/git/SpringDemo/HTTPClient/src/Test1.txt";
		
		// Method Check GET or PUT
		if ("GET".equals(command)) {
			Client.getMethod(host, port, path);
		} else if ("PUT".equals(command)) {
			Client.putMethod(host, port, path);
		}
		else if(signal==66) {
			Client.terminateServerSignal(host, port, signal);
		}
		else{
			System.out.println("Check the HTTP command! It should be either GET or PUT");
			return;
		}
		
	}

}