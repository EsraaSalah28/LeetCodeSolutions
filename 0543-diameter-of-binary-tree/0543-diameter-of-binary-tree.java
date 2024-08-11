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
   
  int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {

        dfs(root);
          return maxDiameter;

    }

    public int dfs(TreeNode root)
    {
        if (root == null) {
            return 0;
        }
        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);
        int localDiameter = leftDepth+rightDepth;
        maxDiameter = Math.max(maxDiameter, localDiameter);

        return Math.max(rightDepth, leftDepth)+1;



    }
        
    
}