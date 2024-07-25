class Solution {
       public static List<List<Integer>> subsets(int[] nums) {
        List<Integer> prem=new ArrayList<>();
        List<List<Integer>> result=new ArrayList<>();

         backtrack(nums,prem,result,0);
         return result;
    }
        private static void backtrack(int[] nums, List<Integer> prem, List<List<Integer>> result, int start) {
                         result.add(new ArrayList<>(prem));
                          for (int i = start; i < nums.length; i++) {
                              prem.add(nums[i]);
                              backtrack(nums,prem,result,i+1);
                              prem.remove(prem.size()-1);
                          }

    }
}