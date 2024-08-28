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
   public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null)
            return  new ArrayList<>();
        List<List<Integer>> result = new ArrayList <>();
        calc(root,targetSum,new ArrayList<>(),result);
        return result;
    }

    private  void calc (TreeNode root, int targetSum ,List<Integer> currentPath, List<List<Integer>> result) {
        if(root==null)
            return ;
        currentPath.add(root.val);
        if(root.left ==null && root.right ==null&&root.val == targetSum)
        {
           result.add(new ArrayList<>(currentPath));
        }else {
             calc(root.left, targetSum - root.val, currentPath, result);
             calc(root.right, targetSum - root.val, currentPath, result);
        }
        currentPath.removeLast();
    }
}