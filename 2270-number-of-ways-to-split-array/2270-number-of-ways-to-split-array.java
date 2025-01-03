class Solution {
    public int waysToSplitArray(int[] nums) {
        int count=0; int n= nums.length;
        long right[]= new long[n];
        right[n-1]= nums[n-1];
        long prefix[]=new long[n];
         prefix[0]= nums[0];
        for(int i=1;i<n-1;i++)
        {
          prefix[i]=nums[i]+prefix[i-1];
        }
        for(int i=n-2;i>0;i--)
        {
        right[i]=right[i+1]+nums[i];
        }
        for(int i=0;i<n-1;i++)
        {
            if(prefix[i]>=right[i+1])
            count++;
        }
        return count;
    }
}