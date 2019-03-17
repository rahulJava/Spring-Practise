import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Test {

	public static void main(String[] args) {
		 ArrayList<Integer> randList = new ArrayList<Integer>();
	        Random rand = new Random(); 
	        int size =1000;
	        for (int i = 0; i < 100; i++){
	        	System.out.println("value getting add in list:"+size);
	            randList.add(rand.nextInt(size));
	        }
	       
	        Collections.sort(randList, Collections.reverseOrder());
	        System.out.println("print the list:"+randList);
	}
}
