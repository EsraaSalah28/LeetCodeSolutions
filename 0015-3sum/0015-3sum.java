class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res=new HashSet<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2;i++)
        {
            int l =i+1 , r=nums.length-1;
            while(l<r)
            {
                if(nums[l]+nums[r]==-nums[i])
                {
                    res.add(Arrays.asList(nums[l],nums[r],nums[i]));
                    l++;
                    r--;
                }
                else if(nums[r]+nums[l]>-nums[i])
                    r--;
                else
                {
                    l++;
                }
            }
        }
        return new ArrayList<>(res);

    }

}