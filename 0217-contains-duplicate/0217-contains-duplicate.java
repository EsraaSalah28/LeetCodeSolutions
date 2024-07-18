class Solution {
      public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums)
         {
             map.put(num,map.getOrDefault(num,0)+1);
         }
         return map.values().stream().anyMatch(n -> n > 1);

    }
}