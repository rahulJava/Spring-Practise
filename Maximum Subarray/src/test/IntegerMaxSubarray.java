package test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ITSC6114
 */
public class IntegerMaxSubarray extends MaxSubarrayGenericType<Integer>{
    protected Integer add(Integer o1, Integer o2){
        return new Integer(o1.intValue() + o2.intValue());
    }
    protected int compareTo(Integer o1, Integer o2){
        if (o1.intValue() < o2.intValue())
            return -1;
        else
            if (o1.intValue() > o2.intValue())
                return 1;
            else
                return 0;
    }
    
    public static void main(String [] argv){
        Scanner keyboard = new Scanner(System.in);
        String intSequence = keyboard.nextLine();
        
        String[] tokens = intSequence.split(",");
        Integer [] array = new Integer[tokens.length];
        for (int i = 0; i < tokens.length; i++)
            array[i] = new Integer(tokens[i]);
        System.out.println("Main");
        //Integer [] array = {3, -1, -1, 10, -3, -2, 4};
        List<Integer> list = Arrays.asList(array);
        
        ArrayList<Integer> arrayList = new ArrayList<Integer>(list);
        IntegerMaxSubarray mss = new IntegerMaxSubarray();
        SubArrayInfoGenericType<Integer> max = mss.findMSS(arrayList, 0, arrayList.size()-1);
        System.out.println(max.toString());
    }
}
