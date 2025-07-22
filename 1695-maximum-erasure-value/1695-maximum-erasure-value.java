class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int left = 0;
        int right = 1;
        int max = 0;
        Set<Integer> set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
               max += nums[i];
            } else {
                left++;
        
            }
            right++;

        }
        return max;
    }
}