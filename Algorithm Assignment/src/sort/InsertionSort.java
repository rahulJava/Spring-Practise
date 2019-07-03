package sort;

public class InsertionSort {
   public static void sort(int numbers [], int numbersSize) {
      /*
       * FUNCTION FOR SORTING ARRAY USING INSERTION SORT
       */
      
       
        for (int i=1; i<numbersSize; ++i) 
        { 
            int key = numbers[i]; 
            int j = i-1; 
            /*
             * Shifting the elements which are greater than key ahead.
             */
            while (j>=0 && numbers[j] > key) 
            { 
            	numbers[j+1] = numbers[j]; 
                j = j-1; 
            } 
            numbers[j+1] = key; 
        } 
       
   }

   public static void main(String [] args) {
      int numbers [] = {10, 2, 78, 4, 45, 32, 7, 11};
      final int NUMBERS_SIZE = 8;
      int i;

      System.out.print("-----------Insertion Sort---------\nUNSORTED: ");
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
