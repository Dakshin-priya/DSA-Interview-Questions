import java.util.*;

class Node<T> {
  T val;
  Node<T> left;
  Node<T> right;
  
  public Node(T val) {
    this.val = val;
    this.left = null;
    this.right = null;
  }
}

class Source {
  public static List<String> breadthFirstValues(Node<String> root) {
    Queue<Node<String>> q = new LinkedList<>();
    Set<Node<String>> visited = new HashSet<>();
    List<String> res = new ArrayList<>();

    if (root == null) return res;

    q.offer(root);
    while (!q.isEmpty()) {
      Node<String> curr = q.poll();

      if (!visited.contains(curr)) {
        visited.add(curr);
        res.add(curr.val);

        if (curr.left != null)
          q.offer(curr.left);
        if (curr.right != null)
          q.offer(curr.right);
      }
    }
    return res;
  }

  public static void run() {
    // acts like main()
  }
}
