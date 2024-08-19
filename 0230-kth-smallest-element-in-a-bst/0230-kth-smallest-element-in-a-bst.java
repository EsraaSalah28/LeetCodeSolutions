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
     private int count=0;
    private int result=0;
     public  int kthSmallest(TreeNode root, int k) {
        inOrderTraversal(root, k);
        return result;
    }
    public  void inOrderTraversal(TreeNode node , int k)
    {
        if(node == null)
            return;
        inOrderTraversal(node.left,k);
        count++;
        if (count==k) {
            result = node.val;
            return;
        }
        inOrderTraversal(node.right,k);

    }
}