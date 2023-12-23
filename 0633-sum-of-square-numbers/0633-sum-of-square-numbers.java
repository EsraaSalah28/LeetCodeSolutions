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
       long l=0;
        long h= (int) (Math.sqrt(c)) ;
        
        while(l<=h){ 
            long curr=h*h+l*l; 
            if(curr==c) return true;
            if(curr>c ) h--;
            else l++;
        }
        return false;
    }     
    
    
}