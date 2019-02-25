 class MaiximumSubArrayInfo
  {
	  int leftmax , rightmax,sum;
	  public MaiximumSubArrayInfo(int a1,int b1,int c1)
	  {
		  leftmax=a1;
		  rightmax=b1;
		  sum=c1;
	  }
	  static MaiximumSubArrayInfo maximum(MaiximumSubArrayInfo a, MaiximumSubArrayInfo b, MaiximumSubArrayInfo c)
	  {
	    if (a.sum>=b.sum && a.sum>=c.sum)
	      return a;
	    else if (b.sum>=a.sum && b.sum>=c.sum)
	      return b;
	    return c;
	  }
  }