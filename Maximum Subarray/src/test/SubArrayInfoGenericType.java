package test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Qiong
 */
public class SubArrayInfoGenericType<E extends Comparable<E>> {
    int startIndex, endIndex,sum;
    
    public SubArrayInfoGenericType(){
        this.startIndex = 0;
        this.endIndex = 0;
    }
    
    public SubArrayInfoGenericType(int start, int end, int i){
        this.startIndex = start;
        this.endIndex = end;
        this.sum = i;
    }
    
    public int getStart(){
        return startIndex;
    }
    
    public void setStart(int start){
        this.startIndex = start;
    }
    
    public int getEnd(){
        return endIndex;
    }
    
    public void setEnd(int end){
        this.endIndex = end;
    }
    
    public int getSum(){
        return this.sum;
    }
    
    public void setSum( int sum){
        this.sum = sum;
    }
   
//    public int compareTo(SubArrayInfoGenericType<E> other){
//        if (this.sum.compareTo(other.getSum()) < 0)
//            return -1;
//        else if (this.sum.compareTo(other.getSum()) > 0)
//            return 1;
//        else return 0;
//    }
    
    static SubArrayInfoGenericType maximum(SubArrayInfoGenericType maximumSumLeftSubarray, SubArrayInfoGenericType maximumSumRightSubarray, SubArrayInfoGenericType maximumSumCrossingSubarray)
    {
      if (maximumSumLeftSubarray.sum>=maximumSumRightSubarray.sum && maximumSumLeftSubarray.sum>=maximumSumCrossingSubarray.sum)
        return maximumSumLeftSubarray;
      else if (maximumSumRightSubarray.sum>=maximumSumLeftSubarray.sum && maximumSumRightSubarray.sum>=maximumSumCrossingSubarray.sum)
        return maximumSumRightSubarray;
      return maximumSumCrossingSubarray;
    }
    public String toString(){
        return "Sub-array starts at " + this.startIndex + " and ends at " 
                + this.endIndex + " with the total of " + this.sum;
    }
    
    public static void main(String [] argv){
        SubArrayInfoGenericType<Integer> info = new SubArrayInfoGenericType(1,10, 20);
        System.out.println(info.toString());
    }
}
