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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null)
            return false;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            boolean isXFound=false, isYFound=false;
            TreeNode xPath= null , yPath = null;
            for(int i=0 ;i<size;i++)
            {
            TreeNode node = queue.poll();
             if(node.left!=null)
             {
                 if(node.left.val==x)
                 {
                     isXFound=true;
                     xPath=node;
                 }
                  if(node.left.val==y)
                 {
                     isYFound=true;
                     yPath=node;
                 }
                 queue.add(node.left);
             }
                
                 if(node.right!=null)
             {
                 if(node.right.val==x)
                 {
                     isXFound=true;
                     xPath=node;
                 }
                  if(node.right.val==y)
                 {
                     isYFound=true;
                     yPath=node;
                 }
                 queue.add(node.right);
             }
                if(isYFound&&isXFound)
                    return xPath!=yPath;
                if(isYFound&&isXFound)
                    return false;
                
        }
        }
        return false;
    }
}