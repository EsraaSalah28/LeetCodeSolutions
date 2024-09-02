/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
     public int maxDepth(Node root) {
     if (root == null) {
        return 0;
    }
    
    int maxDepth = 0;
    // Recursively find the depth of each child and keep track of the maximum
    for (Node child : root.children) {
        maxDepth = Math.max(maxDepth, maxDepth(child));
    }
    
    // Add 1 to include the current root node
    return maxDepth +1;
    }
}