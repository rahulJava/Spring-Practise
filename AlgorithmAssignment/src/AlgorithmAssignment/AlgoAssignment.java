package AlgorithmAssignment;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class AlgoAssignment {
	
	
	public static void main(String[] args) {
		
		/*
		 * Inserting values in to young tableau
		 * Taking input from the user for rows and columns.
		 * 
		 */		
		Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter The Number Of Matrix Rows");
         
        int matrixRow = scan.nextInt();
         
        System.out.println("Enter The Number Of Matrix Columns");
         
        int matrixCol = scan.nextInt();
		
        int tableau[][] = new int [matrixRow][matrixCol];
		
        Vector<Integer> v1 = new Vector<Integer>();
		
        /*
         * Creating a vector and taking input values from the user that needs to be inserted in Young tableau.
         */
        enterMatrixData(scan, v1, matrixRow, matrixCol);
        
        System.out.println("length of vector :"+v1.size());
       
        /*
         * Insert the values in the tableau.
         */
        insert(tableau, v1,matrixRow,matrixCol);
        
        System.out.println();
        
        System.out.println("Your  Young Tableau");
        printMatrix(tableau, matrixRow, matrixCol);
        
        /*
         * Extracting min value from tableau
         */
        
        
        int min = extractMin(tableau,matrixRow,matrixCol);
        System.out.println("min value:"+min);
        System.out.println("Young tableau after removing min value");
        printMatrix(tableau, matrixRow, matrixCol);
        
        /*
         * Checking if particular value exist in the tableau.
         */
        int key =69;
        //Algorithm for checking if a value is there in young tableau in o(m+n) complexity
        boolean keyExists= search(tableau, key,matrixRow,matrixCol);
        System.out.println("key:"+key+"::"+keyExists);
		
	}
	public static void insert(int tableau[][], int i, int j)
	{
		// base case
		if (i == 0 && j == 0) {
			return;
		}
		
		// handle separately for the first row
		if (i == 0)
		{
			if (tableau[i][j] < tableau[i][j-1]) {
				
				int temp =tableau[i][j];
				tableau[i][j]=tableau[i][j-1];
				tableau[i][j-1]=temp;
				insert(tableau, i, j - 1);
			}
			return;
		}

		// handle separately for the first column
		if (j == 0)
		{
			if (tableau[i][j] < tableau[i-1][j]) {
				/*
				 * swapping tableau[i][j] and tableau[i-1][j]
				 */
				int temp =tableau[i][j];
				tableau[i][j]=tableau[i-1][j];
				tableau[i-1][j]=temp;
				insert(tableau, i - 1, j);
			}
			return;
		}

		if (tableau[i][j] < tableau[i-1][j])	// go up
		{
			/*
			 * swapping tableau[i][j]and tableau[i-1][j]
			 */
			int temp =tableau[i][j];
			tableau[i][j]=tableau[i-1][j];
			tableau[i-1][j]=temp;
			insert(tableau, i - 1, j);
		}

		if (tableau[i][j] < tableau[i][j-1])	// go left
		{
			/* 
			 * swapping tableau[i][j] and tableau[i][j-1]
			 */
			int temp = tableau[i][j];
			tableau[i][j]=tableau[i][j-1];
			tableau[i][j-1]=temp;
			insert(tableau, i, j - 1);
		}
	}
	
	public static void insert(int tableau[][], Vector v,int i , int j)
	{
		int m= i;
		int n=j;
		// initialize the Young tableau by infinity
		System.out.println("Initially initializong all the value with infinity");
		for (int[] row : tableau) 
		{
			
			Arrays.fill(row, Integer.MAX_VALUE);
		}
		
		printMatrix(tableau, i, j);
		System.out.println("=============");
		Iterator value = v.iterator();
		// do for each key
		while(value.hasNext())
		{
			// check for overflow
			if (tableau[m-1][n-1] != Integer.MAX_VALUE) {
				
				System.out.println("Young tableau is full. Skipping key:"+value.next());
			}
			else {
				// place key at the bottom right corner of the tableau 
				tableau[m-1][n-1] = (int) value.next();
				
				// move the key to its correct position in the tableau
				insert(tableau, m-1, n-1);
			}
		}	
	}
	public static void youngify(int tableau[][], int i, int j,int matrixRow,int matrixCol)
	{
		int l= matrixRow;
		int m = matrixCol;
		// get the values present at the bottom and right cell of the current cell
		int bottom = (i + 1 < matrixRow) ? tableau[i + 1][j] : Integer.MAX_VALUE;
		int right = (j + 1 < matrixCol) ? tableau[i][j + 1] : Integer.MAX_VALUE;

		if (bottom < right)	// go down
		{
			/*
			 * swapipping tableau[i + 1][j] and tableau[i][j]
			 */
			int temp =tableau[i + 1][j];
			tableau[i + 1][j]=tableau[i][j];
			tableau[i][j]=temp;
			youngify(tableau, i + 1, j,l,m);
		}

		if (bottom > right)	// go right
		{
			/*
			 * swapping tableau[i][j + 1] and tableau[i][j]
			 */
			int temp=tableau[i][j + 1];
			tableau[i][j + 1]=tableau[i][j];
			tableau[i][j]=temp;
			youngify(tableau, i, j + 1,l,m);
		}
	}
	/*
	 * Extracting the minimum value from tableau.
	 */
	public static int extractMin(int tableau[][],int matrixRow,int matrixCol)
	{
		// the first cell of tableau stores the minimum element
		int min = tableau[0][0];

		// make the first element as infinity
		tableau[0][0] = Integer.MAX_VALUE;

		// fix the young tableau property
		youngify(tableau, 0, 0,matrixRow,matrixCol);

		return min;
	}
	/*
	 * Method to pring the 2d array.
	 */
	public static void printMatrix(int[][] matrix, int matrixRow, int matrixCol){
	        
	        for (int i = 0; i < matrixRow; i++)
	        {
	            for (int j = 0; j < matrixCol; j++)
	            {
	                System.out.print(matrix[i][j]+"\t\t");
	            }
	             
	            System.out.println();
	        }
	  }
	/*
	 * Method to take user input for tableau.
	 */
	public static void enterMatrixData(Scanner scan, Vector v1, int matrixRow, int matrixCol){
	     System.out.println("Enter Matrix Data");
	          
	          for (int i = 0; i < matrixRow; i++)
	          {
	              for (int j = 0; j < matrixCol; j++)
	              {
	                  int val = scan.nextInt();
	                  v1.add(val);
	              }
	          }
	  }
	/*
	 * Method to search if a value exist in tableau.
	 */
	public static boolean search(int tableau[][], int key,int m, int n)
	{
		// start from the top-rightmost cell of tableau i.e. (0, N-1) cell
		int i = 0, j = n - 1;

		// run till tableau boundary is reached
		while (i < m && j >= 0)
		{
			// if current element is less than the key, increment the row index
			if (tableau[i][j] < key)
				i++;

			// if current element is more than the key, decrement the column index
			else if (tableau[i][j] > key)
				j--;

			// current element is equal to the key
			else
				return true;
		}

		return false;
	}

}
