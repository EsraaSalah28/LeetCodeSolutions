class Solution {
    public int mySqrt(int x) {
        int low =1 , high=x;
           if((x==0)||(x==1)){
            return x;
        }
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(x/mid==mid)
                return mid;
             else if(x/mid<mid)
                high=mid-1;
            else if(x/mid>mid)
                low=mid+1;
        }
        return high;
        
    }
}