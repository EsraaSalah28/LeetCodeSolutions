class Solution {
    public int findMiddleIndex(int[] nums) {
        int rsum =0 , lsum=0;
        if(nums.length<1)
            return -1;
        for(int num :nums)
        {
            rsum+=num; 
        }
        
        for(int i=0;i<nums.length;i++){
            rsum-=nums[i];
            if(rsum==lsum)
            {
                return i;
            }
            lsum+=nums[i];
        }
        return -1;
    }
}
