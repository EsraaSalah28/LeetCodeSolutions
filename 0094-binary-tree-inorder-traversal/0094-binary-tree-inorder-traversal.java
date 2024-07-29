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
          public static List<Integer> inorderTraversal(TreeNode root) {
            ArrayList<List<Integer>> list = new ArrayList<List<Integer>>();
            if(root!=null){
                list.add(inorderTraversal(root.left));
            int val = root.val;
            list.add(List.of(val));
             list.add(inorderTraversal(root.right));
        }
            return list.stream()
                    .flatMap(List::stream)
                    .collect(Collectors.toList());
        }

}