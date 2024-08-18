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
  public static TreeNode invertTree(TreeNode root) {
    // Base case: if the root is null, just return null.
    if (root == null) return null;
    
    // Recursively invert the left and right subtrees.
    TreeNode left = invertTree(root.left);
    TreeNode right = invertTree(root.right);
    
    // Swap the left and right children.
    root.left = right;
    root.right = left;
    
    // Return the root which now points to the inverted subtree.
    return root;
}


}