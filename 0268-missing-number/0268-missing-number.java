class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int res=0;
        Set<Integer> hashSet = new HashSet<>();
        for(int i=0;i<n;i++){
            hashSet.add(nums[i]);
        }

        for(int i=0;i<n;i++)
        {
            if(!hashSet.contains(i+1))
               res=i+1;
        }
         return  res;
    }
}