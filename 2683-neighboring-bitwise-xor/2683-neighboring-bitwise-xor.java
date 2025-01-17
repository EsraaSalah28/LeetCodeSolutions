class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int sum=0;
        int n=0;
        if(derived.length==1)
          {
            if(derived[derived.length-1]==1)
             return false;
             else
             return true;
          }
        for(int i=0;i<derived.length-1;i+=2)
        {
         n=derived[i]^derived[i+1];
         sum+=n;
        }
        if(sum==0)
        return true;

        return false;
        
    }
}