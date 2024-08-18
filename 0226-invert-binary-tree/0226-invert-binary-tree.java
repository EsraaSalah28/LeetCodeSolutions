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

public static List<Integer> dfs(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) return list;
    
    // Use a queue to traverse the tree level by level (BFS).
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    
    while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        list.add(node.val);
        
        // Add left and right children to the queue for further traversal.
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
    }
    
    return list;
}
}