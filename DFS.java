import java.util.*;
class Node<T>
{
  T val;
  Node<T> left;
  Node<T> right;

  Node(T val)
  {
    this.val=val;
    this.right=null;
    this.left=null;
  }
}

class Source {
  public static List<String> depthFirstValues(Node<String> root) {
    // todo
    Stack<Node<String>> stack = new Stack<>();
    List<String> res = new ArrayList<>();
    if (root == null) return res;
    stack.push(root);
    while(!stack.empty())
      {
        Node<String> curr=stack.pop();
        res.add(curr.val);
        
        if(curr.right != null)
          stack.add(curr.right);
        if(curr.left !=null)
          stack.add(curr.left);
      }
    return res;
  }

  public static void run() {
    // this function behaves as `main()` for the 'run' command
    // you may sandbox in this function , but should not remove it
  }
}
