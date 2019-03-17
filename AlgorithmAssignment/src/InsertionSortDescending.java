
public class InsertionSortDescending {
	public static void main(String[] args) {
		int [] x = {3,2,8,7,6};
		insertionSortDescending(x);
		for(int i =0;i<x.length;i++)
		{
		System.out.print("::"+x[i]);
		}
	}
	public static void insertionSortDescending(int [] y)
	{
		int n = y.length;
		for(int i=0;i<n-1;i++)
		{
			
			int j = i+1;
			int key = y[j];
			while(j>0 && y[j-1]<key)
			{
				y[j]=y[j-1];
				j--;
				System.out.println("hi");
			}
			y[j]=key;
		}
	}

}
