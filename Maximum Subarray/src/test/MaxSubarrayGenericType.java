package test;

/*
 The goal of the programming task is to practice the divide-and-conquer technique and review the time complexity analysis of recurrences.

Please develop a divide-and-conquer solution of determining a maximum sum of certain subsets of one-dimensional arrays in the running time of O(n lg n). Please also perform the time complexity analysis.

Problem Statement
Maximum Subsequence Sum problem (also called maximum subarrays problem): given an array A with signed integer elements, find a contiguous subarray with a maximum possible sum. 

Finding the Maximum Subsequence Sum

Given an array A of signed integers, design an algorithm that finds a subarray A[i, …, j] such that
A[i ] + A[i + 1] + … + A[j] is maximum in time O(n log n). More specifically, find a pair (i, j) such thatⱯ(x,y) ∑k=i j A[k] > ∑k’=i j A[k’]  .

The intuitive method is to scan all pairs, A[i] and A[j], sum up all elements from A[i] through A[j], and find a maximum sum. However, the solution takes the running time of O( n2 ) . 



To obtain a running time of O(n log n), we can apply the divide-and-conquer method. 

Note the following properties of the Maximum Subsequence Sum (MSS). First, if the array elements are all nonnegative, then the MSS is given by the sum from i = 1 to j = n. Second, if A[i ] < 0 Ɐi, then the MSS can be defined as the element closest to zero. Note that, by definition, we disallow the empty set as a valid input (or solution to) the Maximum Subsequence Sum problem. In addition, note that the MSS is not necessarily unique; there could be more than one subarray which achieves the maximum sum.

Let’s split the sequence in half, recursively solve the problem on both halves and see what we can do. 
The maximum may appear from the left half, right half, or a consecutive subsequence across the element in the middle. As for the last one, we can scan the left subsequence and right subsequence in order to find a left start which gives a maximum sub-sum in the left subsequence, ending in the middle element of the whole sequence, and find a right end which gives a maximum sub-sum in the right subsequence, starting from the middle element of the whole sequence. The procedure can be recursively carried out till the base case (only one element is left in each subsequence.

Divide-and-Conquer in details: 
Generic problem: Find a maximum subarray of A[low...high]
Initial call: low = 1 and high = n
Divide-and-conquer strategy:
1) Divide: A[low...high] into two subarrays of as equal size as possible by
finding the midpoint mid
2) Conquer:
(a) finding maximum subarrays of A[low...mid] and A[mid + 1...high]
(b) finding a max-subarray that crosses the midpoint
3) Combine: returning the max of the three
 */


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Vector;

public abstract class MaxSubarrayGenericType <E extends Comparable<E>> {
    protected abstract E add(E o1, E o2);
    protected abstract int compareTo(E o1, E o2);
    
    private SubArrayInfoGenericType<E> maxSpan(ArrayList<Integer> arr, int low, int mid, int high){
        if ((arr == null) || (arr.size() == 0) || (low > high)) return null;
        
        SubArrayInfoGenericType<E> ret;
        
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        int i;
        int lIndex4Max=0;
        
        int maxleft=0;
        for (i=mid; i>=low; i--)
        { 
          sum = sum+arr.get(i);
          if (sum>leftSum)
          {
            leftSum = sum;
            lIndex4Max=i;
            
          }
             
        }
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        int rIndex4Max=0;
        

        for (i=mid+1; i<=high; i++)
        {
          sum=sum+arr.get(i);
          if (sum>rightSum)
            rightSum = sum;
          rIndex4Max=i;
         
        }
        //TODO Expanding from the middle index to the leftmost index and identify the best left endpoint, (saved to the variable lIndex4Max) with a maximum value (saved to the variable maxSum)
        

        //Save the maxSum to the sum for expanding in the right half 
       ;

	//TODO Expanding from the middle index to the rightmost index and identify the best right endpoint, (saved to the variable rIndex4Max) with a maximum value (saved to the variable maxSum)
        

	//Create a subarray information object with the left endpoint index, right endpoint index, and max sum
        ret = new SubArrayInfoGenericType<E>(lIndex4Max, rIndex4Max, leftSum+rightSum);
        return ret;
    }
    
    public SubArrayInfoGenericType<E> findMSS(ArrayList A, int low, int high)
    {
        if ((A == null) || (A.size() == 0) || (low > high)) return null;
        
        if (high == low) // only one element in an array
        {
          return (SubArrayInfoGenericType<E>) A.get(high);
        }	
            int mid = (low + high)/2;
            
            SubArrayInfoGenericType<E> maximumSumLeftSubarray = findMSS(A, low, mid);
            //TODO Divide section - retrieve the best subarray in the left half and save it to leftMax
            SubArrayInfoGenericType<E> maximumSumRightSubarray = findMSS(A, mid+1, high);
            
            SubArrayInfoGenericType<E> maximumSumCrossingSubarray = maxSpan(A, low, mid, high);
            
            return SubArrayInfoGenericType.maximum(maximumSumLeftSubarray, maximumSumRightSubarray, maximumSumCrossingSubarray);

            //TODO Divide section - retrieve the best subarray in the right half and save it to rightMax
            

            //TODO Retrieving a maximum subarray across the element in the middle and save it to crossMax
            
            
            //TODO Retrieving a maximum among best subarray in the left, best subarray in the right, and a best subarray spanning the element in the middle 
            



       
    }
        
        	
    }

