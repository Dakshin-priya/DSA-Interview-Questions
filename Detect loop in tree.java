import java.util.HashSet;
import java.util.Set;

class Node<T> {
    T val;
    Node<T> left;
    Node<T> right;

    Node(T val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class TreeUtils {

    // Function to detect loop in tree
    public static boolean hasLoop(Node<?> root) {
        Set<Node<?>> visited = new HashSet<>();
        return dfs(root, visited);
    }

    // DFS traversal with visited set
    private static boolean dfs(Node<?> node, Set<Node<?>> visited) {
        if (node == null) return false;

        // If node is already visited, there is a loop
        if (visited.contains(node)) return true;

        visited.add(node);

        // Recursively check left and right subtrees
        if (dfs(node.left, visited)) return true;
        if (dfs(node.right, visited)) return true;

        // Optional: remove node from visited if you want to allow other paths
        // visited.remove(node);

        return false;
    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(1);
        root.left = new Node<>(2);
        root.right = new Node<>(3);
        root.left.left = new Node<>(4);

        // Introduce a loop: node 4 points back to root
        // root.left.left.left = root; // Uncomment to create a loop

        if (hasLoop(root)) {
            System.out.println("Tree has a loop!");
        } else {
            System.out.println("Tree is acyclic (no loop).");
        }
    }
}
