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
    private Integer prev = null;
    private int minDiff = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return minDiff;
        
    }
    public void  dfs(TreeNode root )
    {
        if(root==null)
            return;
        dfs(root.left);
        if(prev!=null)
        minDiff=Math.min(minDiff, root.val-prev);
        prev=root.val;
       dfs(root.right);
    }
}