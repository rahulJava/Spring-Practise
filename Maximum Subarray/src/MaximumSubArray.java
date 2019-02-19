import java.util.HashMap;



class MaxSubarray {
	
  static Test maxCrossingSubarray(int ar[], int low, int mid, int high)
  {
    /*
      Initial leftSum should be -infinity.
    */
    int leftSum = Integer.MIN_VALUE;
    int sum = 0;
    int i;

   
    int maxleft=0;
    for (i=mid; i>=low; i--)
    { 
      sum = sum+ar[i];
      if (sum>leftSum)
      {
        leftSum = sum;
        maxleft=i;
        
      }
         
    }

    
    int rightSum = Integer.MIN_VALUE;
    sum = 0;
    int rightmax=0;

    for (i=mid+1; i<=high; i++)
    {
      sum=sum+ar[i];
      if (sum>rightSum)
        rightSum = sum;
      rightmax=i;
     
    }

    /*
      returning the maximum sum of the subarray
      containing the middle element.
    */
   Test t1=new Test(maxleft, rightmax,leftSum+rightSum );
    return t1;
  }

  // function to calculate the maximum subarray sum
  static Test maxSumSubarray(int ar[], int low, int high)
  {
	  
    if (high == low) // only one element in an array
    {
    	return  new Test( low, high,ar[high]);
      
    }

    // middle element of the array
    int mid = (high+low)/2;
    System.out.println();
    // maximum sum in the left subarray
    
    Test maximumSumLeftSubarray = maxSumSubarray(ar, low, mid);
    // maximum sum in the right subarray
    Test maximumSumRightSubarray = maxSumSubarray(ar, mid+1, high);
    // maximum sum in the array containing the middle element
    Test t1 = maxCrossingSubarray(ar, low, mid, high);

    // returning the maximum among the above three numbers
    return Test.maximum(maximumSumLeftSubarray, maximumSumRightSubarray, t1);
  }

  public static void main(String[] args) {
    int a[] = {  -3, -2, 4,3, -1, -1, 10};
  
    
  
    Test maxsom=maxSumSubarray(a, 0, a.length-1);
    
   
    System.out.println("max value:"+maxsom.sum+"indexes start:"+maxsom.leftmax+"indexes end:"+maxsom.rightmax);
  }
}