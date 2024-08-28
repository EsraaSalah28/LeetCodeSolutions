/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
public int pathSum(TreeNode root, int targetSum) {
    HashMap<Long, Integer> map = new HashMap<>();
    map.put(0L, 1);  // Base case to handle the root being a valid starting point.
    return dfs(root, targetSum, 0L, map);
}

int dfs(TreeNode root, int targetSum, long currentSum, HashMap<Long, Integer> map) {
    if (root == null)
        return 0;

    currentSum += root.val;

    // Count paths where sum == targetSum
    int numCurrPaths = map.getOrDefault(currentSum - targetSum, 0);

    // Store the current path sum in the map
    map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);

    // Recurse to the left and right children
    int left = dfs(root.left, targetSum, currentSum, map);
    int right = dfs(root.right, targetSum, currentSum, map);

    // Combine the results
    int result = numCurrPaths + left + right;

    // Backtrack: remove the current path sum from the map
    map.put(currentSum, map.get(currentSum) - 1);

    return result;
}



     
}