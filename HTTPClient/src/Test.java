
public class Test 
{
	public static void main(String[] args) {
		String test="PUT //Users/rahulratra/Documents/HTTPclient-server-master/HTTPClient/src/test.txt/ HTTP/1.1";
		String xyz=test.substring(test.indexOf("PUT"),test.indexOf(".txt")+4).trim();
		System.out.println("xyz:"+xyz);
		
	}

}
