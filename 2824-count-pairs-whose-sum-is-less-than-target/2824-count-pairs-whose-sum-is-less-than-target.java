class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int count =0;
        int left =0 ;int right=nums.size()-1;
          Collections.sort(nums);
     
        while(left<right)
        {
           
            if (nums.get(left)+nums.get(right)<target)
            { count += right-left;
                left++;
            }
            else
            {
                right--;
            }
        
        
    }
        return count ;
}
}