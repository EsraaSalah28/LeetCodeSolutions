class Solution {
    public boolean judgeSquareSum(int c) {
    //     if(c==0)
    //         return true;
    //   for (int i=0 ;i<Math.sqrt(c);i++)
    //   {
    //       int n=(int)Math.sqrt(c-i*i);
    //       if(i*i+n*n==c)
    //           return true;
    //   }
    // return false;
       long i=0;
        long j= (int) (Math.sqrt(c)) ;
        
        while(i<=j){ 
            long e=j*j+(i*i); 
            if(e==c) return true;
            if(e>c ) j--;
            else i++;
        }
        return false;
    }     
    
    
}