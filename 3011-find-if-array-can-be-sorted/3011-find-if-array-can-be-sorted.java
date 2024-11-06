class Solution {
    public boolean canSortArray(int[] nums) {
        int bitCount=Integer.bitCount(nums[0]);
        int maxSegment=nums[0];
        int minSegment=nums[0];
        int PremaxSegment=-1;
        for(int i=0;i<nums.length;i++)
        {
            if(Integer.bitCount(nums[i])!=bitCount)
            {
                bitCount=Integer.bitCount(nums[i]);
            PremaxSegment= Math.max(PremaxSegment,maxSegment);
                maxSegment=nums[i];
                minSegment=nums[i];
            }
            else
            {
              maxSegment=Math.max(nums[i],maxSegment);
              minSegment=Math.min(nums[i],minSegment);

            }
            if(PremaxSegment>=minSegment)
                return false;
        }

        return true;
        
    }
}