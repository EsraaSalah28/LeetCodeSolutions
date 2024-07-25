class Solution {
public static List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> prem = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        backtrack(nums, prem, result, map);
        return result;
    }

    private static void backtrack(int[] nums, List<Integer> prem, List<List<Integer>> result, HashMap<Integer, Integer> map) {
        if (prem.size() == nums.length) {
            result.add(new ArrayList<>(prem));
            return; // Ensure the function returns immediately after adding the permutation
        }
        for (int num : map.keySet()) {
            if (map.get(num) > 0) {
                prem.add(num);
                map.put(num, map.get(num) - 1);
                backtrack(nums, prem, result, map);
                prem.remove(prem.size() - 1);
                map.put(num, map.get(num) + 1); // Restore the count for backtracking
            }
        }
    }
}