class Solution {
    public boolean judgeSquareSum(int c) {
        if(c==0)
            return true;
      for (int i=0 ;i<Math.sqrt(c);i++)
      {
          int n=(int)Math.sqrt(c-i*i);
          if(i*i+n*n==c)
              return true;
      }
    return false;
    }
    
}