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
     public List<Integer> preorder(Node root) {
          Stack<Node> stack = new Stack<>();
          List<Integer> list = new ArrayList<>();
          if (root == null) {
              return list;
          }
          stack.push(root);
          while (!stack.isEmpty()) {
              Node node = stack.pop();
              list.add(node.val);
              if (node.children != null) {
                  List<Node> children = node.children;
                  for(int i =children.size()-1; i >= 0; i--) {
                      stack.push(children.get(i));
                  }
              }
          }
          return list;
    }
}