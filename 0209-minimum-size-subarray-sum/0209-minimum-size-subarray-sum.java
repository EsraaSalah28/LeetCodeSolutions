class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int windowSum=0;
        int windowLen=Integer.MAX_VALUE;
        int endWindow=0;
        for(int startWindow=0;startWindow<nums.length;startWindow++)
        {
            windowSum+=nums[startWindow];
            while(windowSum>=target)
            {
                 windowLen=Math.min(windowLen,startWindow-endWindow+1);
                 windowSum=  windowSum-nums[endWindow];
                 endWindow++;
            }
           
        }

     return windowLen == Integer.MAX_VALUE ? 0 : windowLen;
    }
}
