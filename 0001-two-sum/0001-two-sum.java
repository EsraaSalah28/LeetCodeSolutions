class Solution {
  public  static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap();
        Integer i1=0;
        Integer i2=0;
        for(int i=0;i<nums.length;i++)
        {
          map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];
            if( map.containsKey(comp)&&map.get(comp)!=i) {
                i1 = map.get(comp);
                i2 = i;

            }
        }
    return new int[]{i1,i2};
    }
}