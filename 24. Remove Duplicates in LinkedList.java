import java.util.HashSet;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    // Function to remove duplicates in one pass
    public void removeDuplicates() {
        if (head == null) return;

        HashSet<Integer> seen = new HashSet<>();
        Node current = head;
        seen.add(current.data);

        while (current.next != null) {
            if (seen.contains(current.next.data)) {
                // Duplicate found, skip the node
                current.next = current.next.next;
            } else {
                // Not a duplicate, add to set
                seen.add(current.next.data);
                current = current.next;
            }
        }
    }

    // Function to print the linked list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(3);

        System.out.println("Original list:");
        list.printList();

        list.removeDuplicates();

        System.out.println("After removing duplicates:");
        list.printList();
    }
}
