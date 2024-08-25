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
      public  static List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
          if (root==null) return new ArrayList<>();
          Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
          while (!queue.isEmpty()) {
              Double avg=0.0;
              Double sum=0.0;
              int size = queue.size();
              for (int i = 0; i < size; i++) {
                  TreeNode node = queue.poll();
                   sum+=node.val;
                  if (node.left!=null) {
                      queue.add(node.left);
                  }
                  if (node.right!=null){
                      queue.add(node.right);
                  }
              }

                  avg=sum/size;
                  list.add(avg);

          }
          return list;
    }

}