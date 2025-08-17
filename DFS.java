import java.util.*;

class Node<T> {
  T val;
  Node<T> left;
  Node<T> right;

  Node(T val) {
    this.val = val;
    this.right = null;
    this.left = null;
  }
}

class Source {
  public static List<String> depthFirstValues(Node<String> root) {
    Stack<Node<String>> stack = new Stack<>();
    Set<Node<String>> visited = new HashSet<>();
    List<String> res = new ArrayList<>();

    if (root == null) return res;

    stack.push(root);
    while (!stack.empty()) {
      Node<String> curr = stack.pop();

      if (!visited.contains(curr)) {
        visited.add(curr);
        res.add(curr.val);

        // Push neighbors (children) to stack
        if (curr.right != null)
          stack.push(curr.right);
        if (curr.left != null)
          stack.push(curr.left);
      }
    }
    return res;
  }

  public static void run() {
    // acts like main()
  }
}
