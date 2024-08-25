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
public void flatten(TreeNode root) {
    if (root == null) {
        return;
    }

    // Recursively flatten the left and right subtrees
    flatten(root.left);
    flatten(root.right);

    // Store the original right subtree
    TreeNode temp = root.right;

    // Move the left subtree to the right
    root.right = root.left;
    root.left = null;

    // Find the rightmost node of the newly moved right subtree
    TreeNode current = root.right;
    while (current != null && current.right != null) {
        current = current.right;
    }

    // Attach the originally saved right subtree
    if (current != null) {
        current.right = temp;
    } else {
        // If there was no left subtree, reattach the right subtree
        root.right = temp;
    }
}


}