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
        public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> listOfLists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        boolean right=true;
        if(root==null)
            return listOfLists;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> lists = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (right)
                {
                    lists.add(node.val);
                }
                else
                {
                    lists.add(0,node.val);
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

         listOfLists.add(lists);
            right = !right;

        }
        return listOfLists;
    }

}