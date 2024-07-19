class Solution {
   public int findDuplicate(int[] nums) {
      HashSet<Integer> set = new HashSet<>();
      int num=0;
      for (int i = 0; i < nums.length; i++) {
          if(!set.contains(nums[i]))
              set.add(nums[i]);
          else {
              num = nums[i];
          }
      }
      return num;
    }
}