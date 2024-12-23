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
    public int minimumOperations(TreeNode root) {
        Queue <TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count=0;
        while(!queue.isEmpty())
        {
             int size=queue.size();
            int levelSize[]=new int[size];
            for(int i =0 ;i<size;i++)
            {
                TreeNode node=queue.poll();
                levelSize[i]=node.val;
                
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            count+= getMinSwaps(levelSize);
            
        }
    return count;}
        private int getMinSwaps(int[] original) {
            
            int swaps=0;
            int [] target = original.clone();
            Arrays.sort(target);
            Map<Integer, Integer> map = new HashMap<>();
            for(int i=0;i<original.length;i++)
            {
                map.put(original[i], i);
            }
            for(int i=0;i<original.length;i++)
            {
                if(original[i]!=target[i])
                {
                    swaps++;
                
               int pos= map.get(target[i]);
                map.put(original[i],pos);
                original[pos]=original[i];
            }}
           return swaps;    
            
        }
      
    
}