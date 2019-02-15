package sort;

import java.util.Arrays;

public class MergeSort {
   public static void merge(int numbers [], int start, int mid, int end) {
	   int n1 = mid - start + 1;
       int n2 = end - mid;
        
       int[] temp1 = new int[n1];
       int[] temp2 = new int[n2];
        
       for(int i = 0; i < n1; i++) {
           temp1[i] = numbers[start+i];
       }
        
       for(int j = 0; j < n2; j++) {
           temp2[j] = numbers[mid+j+1];
       }
        
       int i = 0, j = 0, k = start;
       while(i < n1 && j < n2) {
           if(temp1[i] <= temp2[j]) {
        	   numbers[k] = temp1[i];
               i++;
           } else {
        	   numbers[k] = temp2[j];
               j++;
           }
           k++;
       }
        
       while(i < n1) {
    	   numbers[k] = temp1[i];
           i++;
           k++;
       }
       while(j < n2) {
    	   numbers[k] = temp2[j];
           j++;
           k++;
       }   
       
   }

   public static void merSort(int[] array, int start, int end) {
       if(start < end) {
           int mid = (start+end)/2;
           merSort(array, start, mid);
           merSort(array, mid+1, end);
           merge(array, start, mid, end);	
       }
   }

   public static void main(String [] args) {
	   int[] array = {12, 35, 87, 26, 9, 28, 7};
       merSort(array,0,array.length-1);
       System.out.println(Arrays.toString(array));   
   }
}
