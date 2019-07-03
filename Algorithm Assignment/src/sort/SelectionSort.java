package sort;

public class SelectionSort {
   public static void sort(int numbers [], int numbersSize) {

	   if(numbers == null || numbers.length < 2) {
           return;
       }
       
       for(int i = 0; i < numbersSize; i++) {
           int minIndex = i;   // Finding the index of minimum value available in array of size n
           for(int j = i+1; j < numbersSize; j++) {
               if(numbers[minIndex] > numbers[j]) {
                   minIndex = j;
               }
           }
           /*
            * Once the minimum index of minimum value is found replacing it with current value available 
            * in index i.
            */
           if(i != minIndex && numbers[i] != numbers[minIndex]) {
               swappingNumbers(numbers, i, minIndex);
           }
       }
   
   }
   private static void swappingNumbers(int[] array, int i, int j) {
       int tmp = array[i];
       array[i] = array[j];
       array[j] = tmp;     
   }

   public static void main(String [] args) {
      int numbers [] = {10, 2, 78, 4, 45, 32, 7, 11};
      final int NUMBERS_SIZE = 8;
      int i;

      System.out.print("-----------Selection Sort---------\nUNSORTED: ");
      for (i = 0; i < NUMBERS_SIZE; ++i) {
         System.out.print(numbers[i] + " ");
      }
      System.out.println();

      /* initial call to quicksort with index */
      sort(numbers, NUMBERS_SIZE);

      System.out.print("SORTED: ");
      for (i = 0; i < NUMBERS_SIZE; ++i) {
         System.out.print(numbers[i] + " ");
      }
      System.out.println();
   }
}