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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // Step 1: BFS traversal to populate the map
        Map<Integer, List<int[]>> columnMap = new TreeMap<>();
        Queue<Object[]> queue = new LinkedList<>();
        queue.offer(new Object[]{root, 0, 0}); // [node, row, col]

        while (!queue.isEmpty()) {
            Object[] nodeInfo = queue.poll();
            TreeNode node = (TreeNode) nodeInfo[0];
            int row = (int) nodeInfo[1];
            int col = (int) nodeInfo[2];

            columnMap.putIfAbsent(col, new ArrayList<>());
            columnMap.get(col).add(new int[]{row, node.val});

            if (node.left != null) {
                queue.offer(new Object[]{node.left, row + 1, col - 1});
            }
            if (node.right != null) {
                queue.offer(new Object[]{node.right, row + 1, col + 1});
            }
        }

        // Step 2: Sort the map entries
        List<List<Integer>> result = new ArrayList<>();
        for (int col : columnMap.keySet()) {
            List<int[]> nodes = columnMap.get(col);
            nodes.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            List<Integer> sortedColumn = new ArrayList<>();
            for (int[] node : nodes) {
                sortedColumn.add(node[1]);
            }
            result.add(sortedColumn);
        }

        return result;
    }
}