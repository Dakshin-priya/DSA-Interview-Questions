/*
Base Case: If head is null or only one node → return head (already sorted).

Find the Middle:
  Use slow and fast pointer approach:
   > slow moves 1 step
   > fast moves 2 steps
   > When fast reaches end, slow is at middle.

Split the List: Divide the list into two halves: left and right.
Recursively Sort Both Halves: Call mergeSort(left) and mergeSort(right).
Merge Two Sorted Lists: Use a helper function merge() to merge two sorted linked lists.
*/
class Node {
    int data;
    Node next;
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListMergeSort {

    // Function to merge two sorted linked lists
    private static Node merge(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        if (l1 != null) tail.next = l1;
        else tail.next = l2;

        return dummy.next;
    }

    // Function to find middle of the list
    private static Node getMiddle(Node head) {
        if (head == null) return head;
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Merge Sort function
    public static Node mergeSort(Node head) {
        if (head == null || head.next == null) return head;

        Node middle = getMiddle(head);
        Node nextToMiddle = middle.next;
        middle.next = null; // split the list

        Node left = mergeSort(head);
        Node right = mergeSort(nextToMiddle);

        return merge(left, right);
    }

    // Function to print linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(3);

        System.out.println("Original List:");
        printList(head);

        head = mergeSort(head);

        System.out.println("Sorted List:");
        printList(head);
    }
}
